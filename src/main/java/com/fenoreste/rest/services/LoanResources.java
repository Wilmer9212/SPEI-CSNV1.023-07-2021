/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.services;

import com.fenoreste.rest.ResponseDTO.LoanDTO;
import com.fenoreste.rest.ResponseDTO.LoanFee;
import com.fenoreste.rest.ResponseDTO.LoanPayment;
import com.fenoreste.rest.ResponseDTO.LoanRate;
import com.fenoreste.rest.dao.LoanDAO;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.List;
import javax.ws.rs.Consumes;
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
@Path("/Loan")
public class LoanResources {

    @POST
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response loan(String cadena) {
        System.out.println("Cadena:" + cadena);
        String productBankIdentifier = "";
        JsonObject Error = new JsonObject();
        int feesStatus = 0, pageSize = 0, pageStartIndex = 0;
        LoanDAO dao = new LoanDAO();
        try {
            JSONObject jsonRecibido = new JSONObject(cadena);
            productBankIdentifier = jsonRecibido.getString("productBankIdentifier");
            int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
            int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
            int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
            if(dao.tipoproducto(p)!=2){
                Error.put("Error","Producto no valido para LOANS");
                return Response.status(Response.Status.BAD_REQUEST).entity(Error).build();
            }
            /*feesStatus = jsonRecibido.getInt("feesStatus");
            JSONObject json = jsonRecibido.getJSONObject("paging");
            pageSize = json.getInt("pageSize");
            pageStartIndex = json.getInt("pageStartIndex");*/
        } catch (Exception e) {
            Error.put("Error", "Error en parametros JSON");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Error).build();
        }
       
        int count = 0;
        try {
            LoanDTO loan = dao.Loan(productBankIdentifier);
            JsonObject j = new JsonObject();
            j.put("Loan", loan);
            return Response.status(Response.Status.OK).entity(j).build();
        } catch (Exception e) {
            dao.cerrar();
            Error.put("Error", "SOCIOS NO ENCONTRADOS");
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).entity(Error).build();

        } finally {
            dao.cerrar();
        }

    }

    @POST
    @Path("/Fee")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response loanFee(String cadena) {
        System.out.println("Cadena:" + cadena);
        String productBankIdentifier = "";
        JsonObject Error = new JsonObject();
        int feeNumber = 0;
        LoanDAO dao = new LoanDAO();
        try {
            JSONObject jsonRecibido = new JSONObject(cadena);
            productBankIdentifier = jsonRecibido.getString("productBankIdentifier");
            feeNumber = jsonRecibido.getInt("feeNumber");
            int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
            int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
            int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
            if(dao.tipoproducto(p)!=2){
                Error.put("Error","Producto no valido para LOANS");
                return Response.status(Response.Status.BAD_REQUEST).entity(Error).build();
            }
        } catch (Exception e) {
            Error.put("Error", "Error en parametros JSON");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Error).build();
        }
        
        int count = 0;
        try {
            LoanFee loan = dao.LoanFee(productBankIdentifier, feeNumber);
            JsonObject j = new JsonObject();
            j.put("Fee", loan);
            return Response.status(Response.Status.OK).entity(j).build();
        } catch (Exception e) {
            dao.cerrar();
            Error.put("Error", "SOCIOS NO ENCONTRADOS");
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).entity(Error).build();

        } finally {
            dao.cerrar();
        }
    }

    @POST
    @Path("/Fees")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response loanFees(String cadena) {
        System.out.println("Cadena:" + cadena);
        String productBankIdentifier = "";
        JsonObject Error = new JsonObject();
        int feesStatus = 0, pageSize = 0, pageStartIndex = 0;
        LoanDAO dao = new LoanDAO();
        try{
        String order="";
        try {
            JSONObject jsonRecibido = new JSONObject(cadena);
            productBankIdentifier = jsonRecibido.getString("productBankIdentifier");
            feesStatus = jsonRecibido.getInt("feesStatus");
            JSONObject json = jsonRecibido.getJSONObject("paging");
            pageSize = json.getInt("pageSize");
            pageStartIndex = json.getInt("pageStartIndex");
            order=json.getString("orderByField");
            System.out.println("order:"+order);
            int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
            int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
            int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
            if(dao.tipoproducto(p)!=2){
                Error.put("Error","Producto no valido para LOANS");
                return Response.status(Response.Status.BAD_REQUEST).entity(Error).build();
            }
        } catch (Exception e) {
            Error.put("Error", "Error en parametros JSON");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Error).build();
        }

        
        int count = 0;
        try {
            List<LoanFee> loan = dao.LoanFees(productBankIdentifier, feesStatus, pageSize, pageStartIndex,order);
            JsonObject j = new JsonObject();
            
            int t=dao.contadorGeneral(productBankIdentifier, 1,feesStatus);
            j.put("Fees", loan);
            j.put("LoanFeesCount",t);
            return Response.status(Response.Status.OK).entity(j).build();
        } catch (Exception e) {
            dao.cerrar();
            Error.put("Error", "SOCIOS NO ENCONTRADOS");
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).entity(Error).build();

        } 
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }finally{
            dao.cerrar();
        }
        return null;
    }

    @POST
    @Path("/Rates")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response loanRates(String cadena) {
        System.out.println("Cadena:" + cadena);
        String productBankIdentifier = "";
        JsonObject Error = new JsonObject();
        int pageSize = 0, pageStartIndex = 0;
        LoanDAO dao = new LoanDAO();
        try {
            JSONObject jsonRecibido = new JSONObject(cadena);
            productBankIdentifier = jsonRecibido.getString("productBankIdentifier");
            JSONObject json = jsonRecibido.getJSONObject("paging");
            pageSize = json.getInt("pageSize");
            pageStartIndex = json.getInt("pageStartIndex");
            int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
            int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
            int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
            if(dao.tipoproducto(p)!=2){
                Error.put("Error","Producto no valido para LOANS");
                return Response.status(Response.Status.BAD_REQUEST).entity(Error).build();
            }
        } catch (Exception e) {
            Error.put("Error", "Error en parametros JSON:" + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Error).build();
        }

       int count = 0;
        try {
            List<LoanRate> loan = dao.LoanRates(productBankIdentifier, pageSize, pageStartIndex);
            JsonObject j = new JsonObject();
            int t=3;
            j.put("Rates", loan);
            j.put("LoanRatesCount",t);
            return Response.status(Response.Status.OK).entity(j).build();
        } catch (Exception e) {
            dao.cerrar();
            Error.put("Error", "SOCIOS NO ENCONTRADOS");
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).entity(Error).build();

        } finally {
            dao.cerrar();
        }
    }
    
    @POST
    @Path("/Payments")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response loanPayments(String cadena) {
        System.out.println("Cadena:" + cadena);
        String productBankIdentifier = "";
        JsonObject Error = new JsonObject();
        int pageSize = 0, pageStartIndex = 0;
        LoanDAO dao = new LoanDAO();
        try {
            JSONObject jsonRecibido = new JSONObject(cadena);
            productBankIdentifier = jsonRecibido.getString("productBankIdentifier");
            JSONObject json = jsonRecibido.getJSONObject("paging");
            pageSize = json.getInt("pageSize");
            pageStartIndex = json.getInt("pageStartIndex");
            int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
            int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
            int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
            if(dao.tipoproducto(p)!=2){
                Error.put("Error","Producto no valido para LOANS");
                return Response.status(Response.Status.BAD_REQUEST).entity(Error).build();
            }
        } catch (Exception e) {
            Error.put("Error", "Error en parametros JSON:" + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Error).build();
        }

        
        int count = 0;
        try {
            List<LoanPayment> ListPayment = dao.loanPayments(productBankIdentifier, pageSize, pageStartIndex);
            JsonObject j = new JsonObject();
             int t=dao.contadorGeneral(productBankIdentifier, 2, 0);
            j.put("Payments", ListPayment);
            j.put("LoanPaymentsCount",t);
            return Response.status(Response.Status.OK).entity(j).build();
        } catch (Exception e) {
            dao.cerrar();
            Error.put("Error", "SOCIOS NO ENCONTRADOS");
            System.out.println("Error al convertir cadena a JSON:" + e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).entity(Error).build();

        } finally {
            dao.cerrar();
        }
    }
    

}
