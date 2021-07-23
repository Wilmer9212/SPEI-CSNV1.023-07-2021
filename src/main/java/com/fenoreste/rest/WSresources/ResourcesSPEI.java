/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.WSresources;

import com.fenoreste.rest.Util.CryptoHandler;
import com.fenoreste.rest.Util.OrdenPagoWS;
import com.fenoreste.rest.dao.SPEIDao;
import com.fenoreste.rest.entidades.AuxiliaresPK;
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
        //instanciamos modelo de orden
        OrdenPagoWS ordenPagoWS = new OrdenPagoWS();
        //Instanciamos la clase para firmar nuestra cadena
        CryptoHandler cryptoHandler = new CryptoHandler();
        //metodo para llenar nuestro modelo de orden de pago spei
        
        JsonObject json=new JsonObject();
        SPEIDao dao= new SPEIDao();
       try{
        JSONObject requestJson=new JSONObject(request);
        String cliente=requestJson.getString("cliente");
           System.out.println("request:"+request);
        int o=Integer.parseInt(cliente.substring(0,6));
        int p=Integer.parseInt(cliente.substring(6,11));
        int a=Integer.parseInt(cliente.substring(11,19));
       
        Double monto=0.0;
        monto= requestJson.getDouble("monto");
        
        AuxiliaresPK auxiliaresPK=new AuxiliaresPK(o,p,a);
        JSONObject response=dao.llenarOrdenPago(auxiliaresPK,monto);
        if(response!=null){
            if (response.getJSONObject("resultado").toString().contains("Error")) {
                json.put("Error", response.getJSONObject("resultado").getString("descripcionError"));
                json.put("mensaje", "Error al procesar solicitud");
            } else {
                json.put("id", response.getJSONObject("resultado").getInt("id"));
                json.put("mensaje", "Registrada con exito");
            }
         return Response.status(Response.Status.OK).entity(json).build();
        }else{
            json.put("Error","No se pudo conectar a proveedor Tercero");
        }
        }catch(Exception e){
            dao.cerrar();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }  finally{
           dao.cerrar();
       }      
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(json).build();
    }
    
    
    @Path("srvActualizarEstado")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response servActualizaEstado(String cadena){
        JSONObject request=new JSONObject(cadena);
        int id=request.getInt("id");
        String empresa=request.getString("empresa");
        String folioOrigen=request.getString("folioOrigen");
        String estado=request.getString("estado");
        String causaDevolucion=request.getString("causaDevolucion");
        
        SPEIDao dao=new SPEIDao();
        JsonObject respuesta=new JsonObject();
        try {
         if(dao.actualizaEstadoOrden(id, empresa, folioOrigen, estado, causaDevolucion)){
             respuesta.put("mensaje","recibido");
         }else{
             respuesta.put("mensaje","Error al actualizar estado");
         }
        } catch (Exception e) {
            System.out.println("Error en srv");
        }finally{
            dao.cerrar();
        }
        return Response.status(Response.Status.OK).entity(respuesta).build();
    }

   
}
