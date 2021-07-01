/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author wilmer
 */
@Path("getProductOwnerAndCurrency")
public class TercerosResources {
    @POST
    @Produces({MediaType.APPLICATION_JSON +";charset=utf-8"})
    @Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response altaTerceros(String cadena){
         return null;
    }
        
}
