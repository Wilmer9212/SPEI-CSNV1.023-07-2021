/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.services;

import com.fenoreste.rest.dao.DAOTDD;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.syc.ws.endpoint.siscoop.BalanceQueryResponseDto;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import org.json.JSONObject;

/**
 *
 * @author Elliot
 */
@Path("Test")
public class TestResources {
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response pruebasWS(String pan){
     /*   System.out.println("pan:"+pan);
     DAOTDD tdd=new DAOTDD();
      BalanceQueryResponseDto dto=new BalanceQueryResponseDto();
      JSONObject json=new JSONObject(pan);
      String idcuenta=json.getString("idcuenta");
      
        try {
           dto=tdd.balanceQuery(idcuenta);
            System.out.println("dtoResource:"+dto);
           JsonObject jsonR=new JsonObject();
           jsonR.put("Descripcion",dto.getDescription());
           jsonR.put("Disponible",dto.getAvailableAmount());
           
           return Response.status(Response.Status.OK).entity(jsonR).build();
        } catch (Exception e) {
            System.out.println("Error al construir:"+e.getMessage());
        }finally{
        tdd.cerrar();
    }*/
        return null;
        
    }
    
    
  
}