/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.services;

import com.fenoreste.rest.ResponseDTO.ClientByDocumentDTO;
import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.dao.CustomerDAO;
import com.fenoreste.rest.entidades.usuarios_banca_bankingly;
import com.github.cliftonlabs.json_simple.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author Elliot
 */
@Path("/Clients")
public class CustomerResources {

    @POST
    @Path("/auth")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response credencialesCliente(String cadena) {
        boolean bandera=false;
        JSONObject request=new JSONObject(cadena);
        CustomerDAO dao=new CustomerDAO();
        try {
         
        String user=request.getString("username");
        String ogs=dao.findOGS(user);
        JsonObject json=new JsonObject();
        json.put("ogs",ogs);
        return Response.status(Response.Status.OK).entity(ogs).build();
        } catch (Exception e) {
            System.out.println("error:"+e.getMessage());
        }finally{
            dao.cerrar();
        }
        return null;
    }

    @POST
    @Path("ByDocuments")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response getClientsByDocument(String cadenaJson) throws Throwable {
        System.out.println("Cadena Json:" + cadenaJson);
        JSONObject jsonRecibido = new JSONObject(cadenaJson);
        System.out.println("Request:" + jsonRecibido);
        JsonObject Json_De_Error = new JsonObject();
        JsonObject jsonServido = new JsonObject();
        String DocumentId = jsonRecibido.getString("documentId");
        int ClientType = jsonRecibido.getInt("clientType");
        String Name = jsonRecibido.getString("name");
        String LastName = jsonRecibido.getString("lastName");
        String Mail = jsonRecibido.getString("mail");
        String Phone = jsonRecibido.getString("phone");
        String CellPhone = jsonRecibido.getString("cellPhone");
        String UserName = jsonRecibido.getString("userName");
        usuarios_banca_bankingly usersWeb = new usuarios_banca_bankingly();
        CustomerDAO metodos = new CustomerDAO();
        boolean bande = metodos.findUser(UserName);
        System.out.println("bande:" + bande);
        boolean buscaP = metodos.SearchPersonas(ClientType, DocumentId, Name, LastName, Mail, Phone, CellPhone);
        System.out.println("Persona:" + buscaP);
        boolean ac = buscaP;

        try {
            if (buscaP) {
            } else {
                Json_De_Error.put("Error", "SOCIO NO EXISTE,VERIFIQUE DATOS");
                return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
            }
            if (ac) {
                ClientByDocumentDTO clientes = null;
                if (bande==false){
                    System.out.println("entro");
                    clientes = metodos.getClientByDocument(DocumentId, ClientType, Name, LastName, Mail, Phone, CellPhone, UserName);
                    if (clientes != null) {
                        jsonServido.put("customers", clientes);
                        return Response.status(Response.Status.OK).entity(jsonServido).build();
                    }
                } else {
                    Json_De_Error.put("Error", "ERROR USUARIO YA ESTA REGISTRADO");
                    return Response.status(Response.Status.BAD_REQUEST).entity(Json_De_Error).build();
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return null;
        } finally {
            metodos.cerrar();
        }
        return null;

    }
}
