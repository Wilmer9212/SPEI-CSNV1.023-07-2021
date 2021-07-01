package com.fenoreste.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fenoreste.rest.ResponseDTO.AccountDetailsDTO;
import com.fenoreste.rest.ResponseDTO.AccountLast5MovementsDTO;
import com.fenoreste.rest.ResponseDTO.AccountMovementsDTO;
import com.fenoreste.rest.dao.AccountsDAO;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@Path("/Account")
public class AccountsResources {

    @POST
    @Path("/Details")
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response getAccountDetails(String cadenaJson) {
        String accountId = "";        
        JsonObject Json_De_Error = new JsonObject();
        AccountsDAO metodos = new AccountsDAO();
        try {
            JSONObject jsonRecibido = new JSONObject(cadenaJson);
            accountId = jsonRecibido.getString("productBankIdentifier");
        } catch (Exception e) {
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
        }

        try {
        boolean bande = true;
        //Reccorremos el accountId para veru que solo sean numeros que trae
        for (int i = 0; i < accountId.length(); i++) {
            if (Character.isLetter(accountId.charAt(i))) {
                bande = false;
                System.out.println("Charat:" + accountId.charAt(i));
            }
        }
        System.out.println("Bande:" + bande);
        //Si no trae letras en Identificador de producto(OPA) y la longitud es igual a lo que se maneja en la caja 
        if (bande == true && accountId.length() == 19) {
            AccountDetailsDTO cuenta = null;
            try {
                cuenta = metodos.GetAccountDetails(accountId);
                if (cuenta != null) {
                    return Response.status(Response.Status.OK).entity(cuenta).build();
                } else {
                    Json_De_Error.put("Error", "ERROR PRODUCTO NO ENCONTRADO");
                    metodos.cerrar();
                    return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
                }
            } catch (Exception e) {
                metodos.cerrar();
                return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
            }

        } else {
            Json_De_Error.put("Error", "FORMATO DE INDETIFICADOR INVALIDO");
            metodos.cerrar();
            return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
        }
      } catch (Exception e) {
        metodos.cerrar();
        return null;
      }finally{
       metodos.cerrar();
      }

    }
 
       @POST
    @Path("/Last5Movements")
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response getAccountLast5Movements(String cadenaJson) {
        System.out.println("Cadena Json:" + cadenaJson);
        JSONObject jsonRecibido = new JSONObject(cadenaJson);
        JsonObject Json_De_Error = new JsonObject();
        String accountId = jsonRecibido.getString("productBankIdentifier");
        AccountsDAO metodos = new AccountsDAO();
        try{
        boolean bandera = true;
        for (int i = 0; i < accountId.length(); i++) {
            if (Character.isLetter(accountId.charAt(i))) {
                bandera = false;
            }
        }
        
        List<AccountLast5MovementsDTO> cuentas = new ArrayList<AccountLast5MovementsDTO>();
        AccountLast5MovementsDTO cuentaM = null;
        if (bandera) {
            try {
                 cuentas = metodos.getAccountLast5Movements(accountId);
                if (cuentas.size() > 0) {
                    JsonObject cuentasJson=new JsonObject();
                    cuentasJson.put("Last5Movements",cuentas);
                    return Response.status(Response.Status.OK).entity(cuentasJson).build();
                } else {
                    Json_De_Error.put("Error", "PRODUCTO NO ENCONTRADO");                    
                    return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
                }

            } catch (Exception e) {
                
                return null;
            }

        } else {
            Json_De_Error.put("Error", "CARACTERES INVALIDOS EN ENTRADA");
           return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
        }
        }catch(Exception e){
           
            System.out.println("Error:"+e.getMessage());
        }finally{
            metodos.cerrar();
        }
       return null;
    }
    
    
    @POST
    @Path("/Movements")
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response getAccountMovements(String cadenaJson) {
        AccountsDAO dao = new AccountsDAO();
        String ProductBankIdentifier = "";
        String DateFromFilter = null;
        String DateToFilter = null;
        int PageSize = 0;
        int PageStartIndex = 0;        
        JsonObject Error=new JsonObject();
        String orderBy="";
        try{
        try {
            JSONObject jsonRecibido = new JSONObject(cadenaJson);
            ProductBankIdentifier = jsonRecibido.getString("productBankIdentifier");
            DateFromFilter = jsonRecibido.getString("dateFromFilter");
            DateToFilter = jsonRecibido.getString("dateToFilter");
            JSONObject json = jsonRecibido.getJSONObject("paging");
            PageSize = json.getInt("pageSize");
            PageStartIndex = json.getInt("pageStartIndex");
            orderBy=json.getString("orderByField");
        }catch(Exception e){
            Error.put("Error","Error en parametros JSON");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Error).build();
        }
            int count=0;
            try{
             List<AccountMovementsDTO> MiListaDTO=null;
            MiListaDTO= dao.getAccountMovements(ProductBankIdentifier, DateFromFilter, DateToFilter, PageSize, PageStartIndex,orderBy);
            com.github.cliftonlabs.json_simple.JsonObject j = new com.github.cliftonlabs.json_simple.JsonObject();
            count=dao.contadorAuxD(ProductBankIdentifier, DateFromFilter, DateToFilter);
            if(count>0){
             j.put("MovementsCount",count);
             j.put("Movements", MiListaDTO);    
            }else{
                Error.put("Error", "SIN REGISTROS PARA CUENTA:"+ProductBankIdentifier);
                return Response.status(Response.Status.NO_CONTENT).entity(Error).build();
            }
           
            return Response.status(Response.Status.OK).entity(j).build();
        } catch (Exception e) {
            Error.put("Error","SOCIOS NO ENCONTRADOS");            
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).entity(Error).build();

        } 
        }catch(Exception e){
            dao.cerrar();
            System.out.println("Error al consumir:"+e.getMessage());
        }finally {
            dao.cerrar();
        }
        return null;
}
}