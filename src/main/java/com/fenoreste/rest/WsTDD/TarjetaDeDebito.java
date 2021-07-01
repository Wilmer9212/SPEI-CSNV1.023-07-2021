package com.fenoreste.rest.WsTDD;

import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.entidades.Tablas;
import com.fenoreste.rest.entidades.TablasPK;
import com.fenoreste.rest.entidades.WsFoliosTarjetasSyC1;
import com.fenoreste.rest.entidades.WsFoliosTarjetasSyCPK1;
import com.syc.services.SiscoopTDD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.syc.ws.endpoint.siscoop.BalanceQueryResponseDto;

/**
 *
 * @author Elliot
 */
public class TarjetaDeDebito {
    
   
    
        // CONSULTA Y ACTUALIZA EL SALDO DE LA TarjetaDeDebito
    
    
    
    public Tablas productoParaTdd(){
        EntityManagerFactory emf=AbstractFacade.conexion();
        EntityManager em=emf.createEntityManager();
        try {
            TablasPK pkt = new TablasPK("identificador_uso_tdd", "activa");
            Tablas tb = em.find(Tablas.class, pkt);
            if(tb!=null){
                return tb;
            }else{
                return null;
            }
        } catch (Exception e) {
            em.close();
            emf.close();
            System.out.println("No existe producto activo para tdd:"+e.getMessage());
        }finally{
            em.close();
            emf.close();
        }
        return null;
    }
    private Tablas parametrosConexion(){
      EntityManagerFactory emf=AbstractFacade.conexion();
      EntityManager em=emf.createEntityManager();
        try {
            Tablas tbb=productoParaTdd();
            if(tbb!=null){
            TablasPK tablasPK = new TablasPK("siscoop_banca_movil", "wsdl_parametros");
            Tablas paramc = em.find(Tablas.class, tablasPK);
            
            if(paramc!=null){
                return paramc;
            }else{
                return null;
            }
            }
        } catch (Exception e) {
            em.close();
            emf.close();
            System.out.println("No existen parametros para conexion:"+e.getMessage());
        }finally{
            em.close();
            emf.close();
        }
        return null;
       
    }
    
    public BalanceQueryResponseDto saldoTDD(WsFoliosTarjetasSyCPK1 saldotTddPK) {
        EntityManagerFactory emf=AbstractFacade.conexion();
        EntityManager em=emf.createEntityManager();
        
        BalanceQueryResponseDto response= new BalanceQueryResponseDto();
        WsFoliosTarjetasSyC1 tarjeta =  em.find(WsFoliosTarjetasSyC1.class,saldotTddPK);
        System.out.println("Llegando al web service de SYC");
        try {
                 Tablas tpws=parametrosConexion();
        if (tpws!=null) {
              SiscoopTDD wssyc = new SiscoopTDD(tpws.getDato1(),tpws.getDato2());
            System.out.println("idtjeta:"+tarjeta.getIdtarjeta());
                    if(tarjeta.getActiva()){
                    response = wssyc.getSiscoop().getBalanceQuery(tarjeta.getIdtarjeta());
                    System.out.println("response:"+response.getDescription());
                   
                    /*if (!BalanceQueryResponse(balanceQueryResponseDto, tarjeta, idusuario)) {
                        System.out.println("Error no se inserto el registro en el log de TDD, tabla ws_siscoop_resultado_final_bancamovil. ");
                    }*/
               
            } else {
                System.out.println("hasta aqui");
                //balanceQueryResponseDto.setCode(0);
                response.setDescription("La tarjeta esta inactiva: " + tarjeta.getIdtarjeta());
            }
       
        }
        }catch(Exception e){
            em.close();
            emf.close();
            System.out.println("Error producido en tdd:"+e.getMessage());
        }finally{
        em.clear();
        em.close();
        emf.close();
        }
       
        System.out.println("responseDTO:"+response);
        return response;
    }
  
    }

    