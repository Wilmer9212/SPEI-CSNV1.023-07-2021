/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.WSresources;

import com.fenorest.rest.DTO.RequestDataOrdenPagoDTO;
import com.fenorest.rest.DTO.ResponseDTO;
import com.fenoreste.rest.dao.SPEIDao;
import com.github.cliftonlabs.json_simple.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author wilmer
 */
@Path("/v1.0")
public class ResourcesSPEI {
    
    //Endpoint para pruebas  
    String url = "https://demo.stpmex.com:7024/speiws/rest/ordenPago/registra";

    @Path("srvEnviaOrden")
    @POST
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response enviarOdenSPEI(String request) throws Exception {
        JsonObject json = new JsonObject();
        SPEIDao dao = new SPEIDao();
        try {
            JSONObject requestJson = new JSONObject(request);
                        
            /*int o = Integer.parseInt(cliente.substring(0, 5));
            int p = Integer.parseInt(cliente.substring(6, 8));
            int a = Integer.parseInt(cliente.substring(8, 14));*/
            RequestDataOrdenPagoDTO ordenRequest=new RequestDataOrdenPagoDTO();
            ordenRequest.setCliente(requestJson.getString("cliente"));
            ordenRequest.setConceptoPago(requestJson.getString("conceptoPago"));
            ordenRequest.setInstitucionContraparte(requestJson.getString("banco"));
            ordenRequest.setMonto(requestJson.getDouble("monto"));
            ordenRequest.setNombreBeneficiario(requestJson.getString("beneficiario"));
            ordenRequest.setRfcCurpBeneficiario(requestJson.getString("rfcCurpBeneficiario"));
            ordenRequest.setCuentaBeneficiario(requestJson.getString("cuentaBeneficiario"));            
            ResponseDTO response = dao.sendOrderPage(ordenRequest);           
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (Exception e) {
            dao.cerrar();
            System.out.println("Error:"+e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } finally {
            dao.cerrar();
        }        
    }

    @Path("srvActualizarEstado")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response servActualizaEstado(String cadena) {
        JSONObject request = new JSONObject(cadena);
        int id = request.getInt("id");
        String empresa = request.getString("empresa");
        String folioOrigen = request.getString("folioOrigen");
        String estado = request.getString("estado");
        String causaDevolucion = request.getString("causaDevolucion");

        SPEIDao dao = new SPEIDao();
        JsonObject respuesta = new JsonObject();
        try {
            String resActualizarEstado=dao.actualizaEstadoOrden(id, empresa, folioOrigen, estado, causaDevolucion);
            if(resActualizarEstado.toUpperCase().contains("EXITO")){
                respuesta.put("mensaje", "recibido");
            } else {
                respuesta.put("mensaje", resActualizarEstado);
            }
        } catch (Exception e) {
            System.out.println("Error en srv:"+e.getMessage());
        } finally {
            dao.cerrar();
        }
        return Response.status(Response.Status.OK).entity(respuesta).build();
    }

}
