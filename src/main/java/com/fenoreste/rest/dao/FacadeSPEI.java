package com.fenoreste.rest.dao;

import com.fenoreste.rest.Util.AbstractFacade;
import com.fenorest.rest.DTO.OrdenPagoWS;
import com.fenorest.rest.DTO.RequestDataOrdenPagoDTO;
import com.fenorest.rest.DTO.ResponseDTO;
import com.fenoreste.rest.Util.SSLClient;
import com.fenoreste.rest.entidades.Auxiliares;
import com.fenoreste.rest.entidades.AuxiliaresPK;
import com.fenoreste.rest.entidades.Bancos;
import com.fenoreste.rest.entidades.EstadosSPEI;
import com.fenoreste.rest.entidades.OrdenesSPEI;
import com.fenoreste.rest.entidades.Persona;
import com.fenoreste.rest.entidades.Tablas;
import com.fenoreste.rest.entidades.TablasPK;
import com.fenoreste.rest.entidades.ws_siscoop_clabe_interbancaria;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public abstract class FacadeSPEI<T> {

    private static EntityManagerFactory emf;
    //Endpoint para pruebas  
    String url = "https://demo.stpmex.com:7024/speiws/rest/ordenPago/registra";

    //Cargamos cacerts donde tambien se añado el certificado que se genero
    /*String trustsStore = "/usr/java/jdk1.8.0_231-amd64/jre/lib/security/cacert";
    String trussStorePassword = "changeit";*/
    public FacadeSPEI(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }

    //Enviamos la orden de pago
    public ResponseDTO sendOrderPage(RequestDataOrdenPagoDTO dataRequest) {
        EntityManager em = emf.createEntityManager();
        OrdenPagoWS orden = new OrdenPagoWS();
        JSONObject jsonObject = new JSONObject();
        JSONObject response = null;
        //Formamos la orden espei
        orden = formarOrdenPago(dataRequest);
        ResponseDTO dtoResponse = new ResponseDTO();
        try {
            //La cuenta 846 es para pruebas de desarrollo
            orden.setInstitucionContraparte(846);
            jsonObject.put("institucionContraparte", orden.getInstitucionContraparte());
            jsonObject.put("empresa", orden.getEmpresa());
            jsonObject.put("claveRastreo", orden.getClaveRastreo());
            jsonObject.put("institucionOperante", orden.getInstitucionOperante());
            jsonObject.put("monto", orden.getMonto());
            jsonObject.put("tipoPago", orden.getTipoPago());
            jsonObject.put("tipoCuentaOrdenante", orden.getTipoCuentaOrdenante());
            jsonObject.put("nombreOrdenante", orden.getNombreOrdenante());
            jsonObject.put("cuentaOrdenante", orden.getCuentaOrdenante());
            jsonObject.put("rfcCurpOrdenante", orden.getRfcCurpOrdenante());
            jsonObject.put("tipoCuentaBeneficiario", orden.getTipoCuentaBeneficiario());
            jsonObject.put("nombreBeneficiario", orden.getNombreBeneficiario());
            jsonObject.put("cuentaBeneficiario", orden.getCuentaBeneficiario());
            jsonObject.put("rfcCurpBeneficiario", orden.getRfcCurpBeneficiario());
            jsonObject.put("conceptoPago", orden.getConceptoPago());
            jsonObject.put("referenciaNumerica", orden.getReferenciaNumerica());
            jsonObject.put("firma", getFirma(orden));
            //Realizo la peticion el web service de STP
            System.out.println("JsonObject:" + jsonObject);
            response = new JSONObject(doPut(url, jsonObject.toString(), "UTF-8"));

            dtoResponse.setId(0);
            dtoResponse.setError("");

            if (response.getJSONObject("resultado").getInt("id") > 3) {
                int id = response.getJSONObject("resultado").getInt("id");
                if (persistirTransferenciaSPEI(orden, id)) {
                    dtoResponse.setId(id);
                } else {
                    dtoResponse.setError("No se puedo persisitir la orden a la base de datos");
                }
            } else {
                int id = response.getJSONObject("resultado").getInt("id");
                String error = response.getJSONObject("resultado").getString("descripcionError");
                dtoResponse.setId(id);
                dtoResponse.setError(error);
            }
        } catch (Exception e) {
            System.out.println("Error al enviar orden:" + e.getMessage());
        }
        em.close();
        return dtoResponse;
    }

    public OrdenPagoWS formarOrdenPago(RequestDataOrdenPagoDTO requestData) {
        EntityManager em = emf.createEntityManager();
        OrdenPagoWS orden = new OrdenPagoWS();
        System.out.println("entra");
        try {
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fechaActual = sdf.format(now).replace("/", "");
            System.out.println("FechaActual:" + fechaActual);
            //Primero busco el socio que esta generando la orden SPEI
            String socio = "SELECT * FROM personas WHERE replace(to_char(idorigen,'099999')||to_char(idgrupo,'09')||to_char(idsocio,'099999'),' ','')='" + requestData.getCliente() + "'";
            System.out.println("Socio:" + socio);
            Query socio_ = em.createNativeQuery(socio, Persona.class);
            Persona p = (Persona) socio_.getSingleResult();
            //Busco el banco al que se destinaran los fondos
            String banco = "SELECT * FROM bancos WHERE nombre LIKE'%" + requestData.getInstitucionContraparte().toUpperCase() + "%'";
            System.out.println("Banco:" + banco);
            Query banco_ = em.createNativeQuery(banco, Bancos.class);
            Bancos institucionDestino = (Bancos) banco_.getSingleResult();
            //Busco la empresa ordenante
            TablasPK tbpk = new TablasPK("spei_csn", "empresa");
            Tablas tbempresa = em.find(Tablas.class, tbpk);
            //Genero la clave de rastreo
            Random rnd = new Random();
            String claveRastreo = tbempresa.getDato1() + fechaActual + String.valueOf(rnd.nextInt(500000000 - 4 + 2) + 5);
            System.out.println("claveRastreo:" + claveRastreo.length());

            //para csn siempre sera el producto 133
            orden.setInstitucionContraparte(institucionDestino.getIdbanco());
            orden.setEmpresa(tbempresa.getDato1());
            orden.setClaveRastreo(claveRastreo);
            //Institucion operante es fijo para STP
            orden.setInstitucionOperante(90646);
            orden.setMonto(String.valueOf(requestData.getMonto()));
            //Tipo pago es fijo (1.-Tercero-Tercero)
            orden.setTipoPago(1);
            //Estatico porque solo se manejan cuentas clabe
            orden.setTipoCuentaOrdenante(40);
            orden.setNombreOrdenante(p.getNombre() + " " + p.getAppaterno() + " " + p.getApmaterno());
            //Buscamos la cuenta ordenante para la persona
            //Obtengo el auxiliar con con el producto 133 TDD que es el que opera para TDD
            String auxi = "SELECT * FROM auxiliares WHERE replace(to_char(idorigen,'099999')||to_char(idgrupo,'09')||to_char(idsocio,'099999'),' ','')='" + requestData.getCliente() + "' AND idproducto=" + 133;
            System.out.println("RegistroAuxiliar:" + auxi);
            Query productoSPEI_ = em.createNativeQuery(auxi, Auxiliares.class);
            Auxiliares a = (Auxiliares) productoSPEI_.getSingleResult();
            System.out.println("aa:" + a);
            AuxiliaresPK auxPK = new AuxiliaresPK(a.getAuxiliaresPK().getIdorigenp(), a.getAuxiliaresPK().getIdproducto(), a.getAuxiliaresPK().getIdauxiliar());
            ws_siscoop_clabe_interbancaria clabe = em.find(ws_siscoop_clabe_interbancaria.class, auxPK);
            orden.setCuentaOrdenante(clabe.getClabe());
            orden.setRfcCurpOrdenante(p.getCurp());
            orden.setTipoCuentaBeneficiario(40);
            orden.setNombreBeneficiario(requestData.getNombreBeneficiario());
            orden.setCuentaBeneficiario(requestData.getCuentaBeneficiario());
            orden.setRfcCurpBeneficiario(requestData.getRfcCurpBeneficiario());
            int referenciaNumerica = rnd.nextInt(300000 - 8 + 1) + 7;
            orden.setConceptoPago(requestData.getConceptoPago());
            orden.setReferenciaNumerica(referenciaNumerica);
            //lo utilizo para darle la numeracion que la documentacion me pide
            DecimalFormat df1 = new DecimalFormat("#.00");
            df1.setMaximumFractionDigits(2);
            df1.setMaximumIntegerDigits(19);
            String montoCodificado = "";
            if (df1.getMaximumIntegerDigits() == 19 && df1.getMaximumFractionDigits() == 2) {
                montoCodificado = df1.format(new BigDecimal(orden.getMonto()));
            }
            orden.setMonto(montoCodificado);
        } catch (Exception e) {
            System.out.println("Error al llenar orde pago SPEI:" + e.getMessage());
        }
        return orden;
    }

    //Persistimos nuestra Transferencia SPEI
    public boolean persistirTransferenciaSPEI(OrdenPagoWS orden, int idOrden) {
        EntityManager em = emf.createEntityManager();
        try {
            long time = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(time);
            em.getTransaction().begin();
            OrdenesSPEI ordenSPEI = new OrdenesSPEI();
            ordenSPEI.setIdorden(idOrden);
            ordenSPEI.setClaverastreo(orden.getClaveRastreo());
            ordenSPEI.setConceptopago(orden.getConceptoPago());
            ordenSPEI.setCuentabeneficiario(orden.getCuentaBeneficiario());
            ordenSPEI.setCuentaordenante(orden.getCuentaOrdenante());
            ordenSPEI.setEmpresa(orden.getEmpresa());
            ordenSPEI.setInstitucioncontraparte(orden.getInstitucionContraparte());
            ordenSPEI.setInstitucionoperante(orden.getInstitucionOperante());
            ordenSPEI.setMonto(Double.parseDouble(orden.getMonto()));
            ordenSPEI.setNombrebeneficiario(orden.getNombreBeneficiario());
            ordenSPEI.setNombreordenante(orden.getNombreOrdenante());
            ordenSPEI.setReferencianumerica(orden.getReferenciaNumerica());
            ordenSPEI.setRfccurpbeneficiario(orden.getRfcCurpBeneficiario());
            ordenSPEI.setRfccurpordenante(orden.getNombreOrdenante());
            ordenSPEI.setTipocuentabeneficiario(orden.getTipoCuentaBeneficiario());
            ordenSPEI.setTipocuentaordenante(orden.getTipoCuentaOrdenante());
            ordenSPEI.setTipopago(orden.getTipoPago());
            ordenSPEI.setEstatus("Enviado");
            ordenSPEI.setFechaejecucion(timestamp);
            em.persist(ordenSPEI);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.out.println("Exception al persistir:" + e.getMessage());
            return false;
        }
        em.close();
        return true;
    }

    //Metodo para que proveedor me actualize estado de orden spei
    public String actualizaEstadoOrden(int idOrden, String empresa, String folioOrigen, String estado, String causaDevolucion) {
        EntityManager em = emf.createEntityManager();
        String message = "";
        try {
            OrdenesSPEI orden1 = em.find(OrdenesSPEI.class, idOrden);
            long time = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(time);
            if (orden1 != null) {
                if (!estado.equals("")) {
                    if (!causaDevolucion.equals("")) {
                        em.getTransaction().begin();
                        orden1.setEstatus(estado);                        
                        EstadosSPEI estados = new EstadosSPEI();
                        estados.setIdorden(idOrden);
                        estados.setEmpresa(empresa);
                        estados.setFolioorigen(folioOrigen);
                        estados.setEstado(estado);
                        estados.setCausadevolucion(causaDevolucion);
                        estados.setFhoraaplicado(timestamp);
                        em.persist(estados);
                        em.persist(orden1);
                        em.getTransaction().commit();
                        message = "Estado actualizado con exito";
                    }else{
                        message="Causa devolucion no valida";
                    }
                }else{
                    message="Estado invalido";
                }
            } else {
                message = "Orden:" + idOrden + " no existe";
            }

        } catch (Exception e) {
            em.close();
            em.getTransaction().rollback();
            em.getTransaction().commit();
            System.out.println("Error:" + e.getMessage());
            System.out.println("Fallo al Actualizar estados para:" + idOrden);
            message = "Orden:" + idOrden + " no existe";
            return message;
        }
        em.close();
        return message;

    }

    //Consigo la firma codificando mi cadena 
    public String getFirma(OrdenPagoWS oPW) {
        StringBuilder sB = new StringBuilder();
        String firma = "";
        try {
            sB.append("||");
            sB.append(oPW.getInstitucionContraparte()).append("|");
            sB.append(oPW.getEmpresa()).append("|");
            sB.append(oPW.getFechaOperacion() == null ? "" : oPW.getFechaOperacion()).append("|");
            sB.append(oPW.getFolioOrigen() == null ? "" : oPW.getFolioOrigen()).append("|");
            sB.append(oPW.getClaveRastreo() == null ? "" : oPW.getClaveRastreo()).append("|");
            sB.append(oPW.getInstitucionOperante() == null ? "" : oPW.getInstitucionOperante()).append("|");
            sB.append(oPW.getMonto() == null ? "" : oPW.getMonto()).append("|");
            sB.append(oPW.getTipoPago() == null ? "" : oPW.getTipoPago()).append("|");
            sB.append(oPW.getTipoCuentaOrdenante() == null ? "" : oPW.getTipoCuentaOrdenante()).append("|");
            sB.append(oPW.getNombreOrdenante() == null ? "" : oPW.getNombreOrdenante()).append("|");
            sB.append(oPW.getCuentaOrdenante() == null ? "" : oPW.getCuentaOrdenante()).append("|");
            sB.append(oPW.getRfcCurpOrdenante() == null ? "" : oPW.getRfcCurpOrdenante()).append("|");
            sB.append(oPW.getTipoCuentaBeneficiario() == null ? "" : oPW.getTipoCuentaBeneficiario()).append("|");
            sB.append(oPW.getNombreBeneficiario() == null ? "" : oPW.getNombreBeneficiario()).append("|");
            sB.append(oPW.getCuentaBeneficiario() == null ? "" : oPW.getCuentaBeneficiario()).append("|");
            sB.append(oPW.getRfcCurpBeneficiario() == null ? "" : oPW.getRfcCurpBeneficiario()).append("|");
            sB.append(oPW.getEmailBeneficiario() == null ? "" : oPW.getEmailBeneficiario()).append("|");
            sB.append(oPW.getTipoCuentaBeneficiario2() == null ? "" : oPW.getTipoCuentaBeneficiario2()).append("|");
            sB.append(oPW.getNombreBeneficiario2() == null ? "" : oPW.getNombreBeneficiario2()).append("|");
            sB.append(oPW.getCuentaBeneficiario2() == null ? "" : oPW.getCuentaBeneficiario2()).append("|");
            sB.append(oPW.getRfcCurpBeneficiario2() == null ? "" : oPW.getRfcCurpBeneficiario2()).append("|");
            sB.append(oPW.getConceptoPago() == null ? "" : oPW.getConceptoPago()).append("|");
            sB.append(oPW.getConceptoPago2() == null ? "" : oPW.getConceptoPago2()).append("|");
            sB.append(oPW.getClaveCatUsuario1() == null ? "" : oPW.getClaveCatUsuario1()).append("|");
            sB.append(oPW.getClaveCatUsuario2() == null ? "" : oPW.getClaveCatUsuario2()).append("|");
            sB.append(oPW.getClavePago() == null ? "" : oPW.getClavePago()).append("|");
            sB.append(oPW.getReferenciaCobranza() == null ? "" : oPW.getReferenciaCobranza()).append("|");
            sB.append(oPW.getReferenciaNumerica() == null ? "" : oPW.getReferenciaNumerica()).append("|");
            sB.append(oPW.getTipoOperacion() == null ? "" : oPW.getTipoOperacion()).append("|");
            sB.append(oPW.getTopologia() == null ? "" : oPW.getTopologia()).append("|");
            sB.append(oPW.getUsuario() == null ? "" : oPW.getUsuario()).append("|");
            sB.append(oPW.getMedioEntrega() == null ? "" : oPW.getMedioEntrega()).append("|");
            sB.append(oPW.getPrioridad() == null ? "" : oPW.getPrioridad()).append("|");
            sB.append(oPW.getIva() == null ? "" : oPW.getIva()).append("||");
            String cadena = sB.toString();
            String firmaSincodificar = sign(cadena);
            firma = firmaSincodificar;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("e:" + e.getMessage());
        }
        return firma;
    }

    //Consigo mi firma
    public String sign(String cadena) throws Exception {
        String firmaCod;
        //Direccion de mi keystore local
        String fileName = "/home/wilmer/respaldo/ProyectosJavaPruebas/CA/feno.jks";
        //Direccion en CSN
        //String fileName = "/home/solvetic/Certificados/speiTest/feno.jks";
        //pass
        String password = "f3n0r3st3";
        //alias
        String alias = "fenoresteca";
        try {
            String data = cadena;
            Signature firma = Signature.getInstance("SHA256withRSA");
            RSAPrivateKey llavePrivada = getCertified(fileName, password, alias);
            firma.initSign(llavePrivada);
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            firma.update(bytes, 0, bytes.length);
            Base64.Encoder encoder = Base64.getEncoder();
            firmaCod = encoder.encodeToString(firma.sign());
            System.out.println("Firma: " + firmaCod);
        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
            throw new Exception("Exceptions" + e.getMessage(), e.getCause());
        }
        return firmaCod;
    }

    private RSAPrivateKey getCertified(String keystoreFilename, String password, String alias) throws Exception {
        RSAPrivateKey privateKey;
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(keystoreFilename), password.toCharArray());
            privateKey = (RSAPrivateKey) keystore.getKey(alias, password.toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | IOException | CertificateException ex) {
            throw new Exception("Exception" + ex.getMessage(), ex.getCause());
        }
        return privateKey;
    }

    public static String doPut(String url, String jsonstr, String charset) {
        HttpClient httpClient = null;
        HttpPut httpPut = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPut = new HttpPut(url);
            httpPut.addHeader("Content-Type", "application/json");
            StringEntity se = new StringEntity(jsonstr);
            se.setContentType("application/json");
            httpPut.setEntity(se);
            HttpResponse response = httpClient.execute(httpPut);
            if (response != null) {
                System.out.println("Response:" + response);
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                    System.out.println("result:" + result);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error en el consumo");
            ex.printStackTrace();
        }
        return result;
    }

    public void cerrar() {
        emf.close();
    }
}
