
package com.fenoreste.rest.services;


import com.fenorest.rest.Auth.Security;
import com.fenoreste.rest.ResponseDTO.ProductsConsolidatePositionDTO;
import com.fenoreste.rest.ResponseDTO.ProductsDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fenoreste.rest.dao.ProductsDAO;
import com.fenoreste.rest.entidades.UserRest;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.ArrayList;
import javax.ws.rs.HeaderParam;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author Elliot
 */
@Path("/Products")
public class ProductsResources {
    @POST
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response GetPRoducts(String cadena) {
        String ClientBankIdentifiers = "";
        Integer ProductTypes = null;
        JsonObject jsonError=new JsonObject();
        ProductsDAO dao = new ProductsDAO();
        Security scr = new Security();
        /*if(!scr.isUserAuthenticated(authString)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }*/
        try {
            JSONObject Object = new JSONObject(cadena);
            JSONArray jsonCB = Object.getJSONArray("clientBankIdentifiers");
            JSONArray jsonPB = Object.getJSONArray("productTypes");
            for (int i = 0; i < jsonCB.length(); i++) {
                JSONObject jCB = (JSONObject) jsonCB.get(i);
                ClientBankIdentifiers = jCB.getString("value");
            }
            for (int x = 0; x < jsonPB.length(); x++) {
                JSONObject jPB = (JSONObject) jsonPB.get(x);
                ProductTypes = jPB.getInt("value");
            }
        } catch (Exception e) {
            jsonError.put("Error","Request Failed");
            dao.cerrar();
            return Response.status(Response.Status.BAD_REQUEST).entity(jsonError).build();
            
        }
        try {
            List<ProductsDTO> listaDTO = dao.getProductos(ClientBankIdentifiers, ProductTypes);
            if (listaDTO != null) {
                JsonObject jsonD = new JsonObject();                    
                jsonD.put("Products",listaDTO);
                return Response.status(Response.Status.OK).entity(jsonD).build();
                }
            else {
                jsonError.put("Error", "DATOS NO ENCONTRADOS");
                return Response.status(Response.Status.NO_CONTENT).entity(jsonError).build();
            }
        } catch (Exception e) {
            System.out.println("Error interno en el servidor");
            dao.cerrar();
        } finally {
            dao.cerrar();
        }

        return null;

    }

    @POST
    @Path("/ConsolidatedPosition")
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response getProductsConsolidatedPosition(String cadena) {
        /*SOLO FALTA DEL CATALOGO CAN TRANSACT ID*/
        System.out.println("Cadena:"+cadena);
        String ClientBankIdentifiers = "", ProductBankIdentifiers = "";
        JsonObject jsonError=new JsonObject();
        List<String>productsBank=new ArrayList<String>();
        try {
            JSONObject Object = new JSONObject(cadena);
            JSONArray jsonCB = Object.getJSONArray("clientBankIdentifiers");
            JSONArray jsonPB = Object.getJSONArray("productBankIdentifiers");
            for (int i = 0; i < jsonCB.length(); i++) {
                JSONObject jCB = (JSONObject) jsonCB.get(i);
                ClientBankIdentifiers = jCB.getString("value");
                System.out.println("ClientBankIdentifiers:" + ClientBankIdentifiers);
            }
            for (int x = 0; x < jsonPB.length(); x++) {
                JSONObject jPB =jsonPB.getJSONObject(x);
                ProductBankIdentifiers = jPB.getString("value");
                System.out.println("ProductBankIdentifiers:" + ProductBankIdentifiers);
                productsBank.add(ProductBankIdentifiers);
            }
        } catch (Exception e) {
            System.out.println("Error al convertir Json:" + e.getMessage());
        }
        System.out.println("Lista de opas:"+productsBank);
        ProductsDAO dao = new ProductsDAO();
        try {
            List<ProductsConsolidatePositionDTO> ListPC = dao.ProductsConsolidatePosition(ClientBankIdentifiers, productsBank);
            if (ListPC != null) {
                    JsonObject k =new JsonObject();
                    k.put("ConsolidatedPosition",ListPC);
              return Response.status(Response.Status.OK).entity(k).build();
                
            } else {
                jsonError.put("Error", "DATOS NO ENCONTRADOS");
                return Response.status(Response.Status.NO_CONTENT).entity(jsonError).build();
            }
        } catch (Exception e) {
            System.out.println("Error aqui:" + e.getMessage());
            dao.cerrar();
        } finally {
            dao.cerrar();
        }
 
        return null;

    }
}
