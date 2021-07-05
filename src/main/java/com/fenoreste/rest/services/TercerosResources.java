/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.services;

import com.fenoreste.rest.Request.ThirdPartyProduct;
import com.fenoreste.rest.ResponseDTO.BackendOperationResultDTO;
import com.fenoreste.rest.ResponseDTO.Bank;
import com.fenoreste.rest.ResponseDTO.ThirdPartyProductDTO;
import com.fenoreste.rest.ResponseDTO.destinationDocumentIdDTO;
import com.fenoreste.rest.ResponseDTO.userDocumentIdDTO;
import com.fenoreste.rest.dao.TercerosDAO;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author wilmer
 */
@Path("/Third")
public class TercerosResources {
    
    @Path("/Party/Product/Validate")
    @POST
    @Produces({MediaType.APPLICATION_JSON +";charset=utf-8"})
    @Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response validarTerceros(String cadena){
         System.out.println("Request Terceros:"+cadena);
         
        ArrayList<String> clientBankIdentifiers_=new ArrayList<>();
        String thirdPartyProductNumber_;
        String thirdPartyProductBankIdentifier_;
        String alias_;
        String currencyId_;
        Integer transactionSubType_;
        Integer thirdPartyProductType_;
        Integer productType_;
        String ownerName_;
        String  ownerCountryId_;
        String ownerEmail_;
        String ownerCity_;
        String ownerAddress_;
        userDocumentIdDTO ownerDocumentId_ = new userDocumentIdDTO();
        String ownerPhoneNumber_;
        Bank bank_=new Bank();
        Bank correspondentBank_=new Bank();
        userDocumentIdDTO userDocumentId_ = new userDocumentIdDTO();
        ThirdPartyProductDTO dtoTercero = new ThirdPartyProductDTO();
         try {
            JSONObject request=new JSONObject(cadena);
            //Obtenemos la lista de clientes en el json
            JSONArray clientBankIdentifiers=request.getJSONArray("clientBankIdentifiers");
            for(int i=0;i<clientBankIdentifiers.length();i++){
                clientBankIdentifiers_.add(clientBankIdentifiers.getString(i));
            }
            
            
            thirdPartyProductNumber_=request.getString("thirdPartyProductNumber");
            thirdPartyProductBankIdentifier_=request.getString("thirdPartyProductBankIdentifier");
            alias_=request.getString("alias");
            currencyId_=request.getString("currencyId");
            transactionSubType_=request.getInt("transactionSubType");
            thirdPartyProductType_=request.getInt("thirdPartyProductType");
            productType_=request.getInt("productType");
            ownerName_=request.getString("ownerName");
            ownerCountryId_=request.getString("ownerCountryId");
            ownerEmail_=request.getString("ownerEmail");
            ownerCity_=request.getString("ownerCity");
            ownerAddress_=request.getString("ownerAddress");
            ownerPhoneNumber_=request.getString("ownerPhoneNumber");
             
            
            //Obtenemos el objeto userDocumentId para ownerDocumentId
            JSONObject ownerDocumentId=request.getJSONObject("ownerDocumentId");
            ownerDocumentId_.setDocumentNumber(ownerDocumentId.getString("documentNumber"));
            ownerDocumentId_.setDocumentType(ownerDocumentId.getString("documentType"));
            ownerDocumentId_.setIntegrationProperties(ownerDocumentId.getString("integrationProperties"));
            
            //Obtenemos el objeto Bank para bank
            JSONObject bank=request.getJSONObject("bank");
            bank_.setBankId(bank.getInt("bankId"));
            bank_.setCountryId(bank.getString("countryId"));
            bank_.setDescription(bank.getString("description"));
            bank_.setHeadQuartersAddress(bank.getString("headQuartersAddress"));
            bank_.setRoutingCode(bank.getString("routingCode"));
             
            
             System.out.println("ssssss");
            //Obtenemos el objeto Bank para correspondentBank
            JSONObject correspondentBank=request.getJSONObject("correspondentBank");
            correspondentBank_.setBankId(correspondentBank.getInt("bankId"));
            correspondentBank_.setCountryId(correspondentBank.getString("countryId"));
            correspondentBank_.setDescription(correspondentBank.getString("description"));
            correspondentBank_.setHeadQuartersAddress(correspondentBank.getString("headQuartersAddress"));
            correspondentBank_.setRoutingCode(correspondentBank.getString("routingCode"));
            
            //Obtenemos el objeto userDocumentId para ownerDocumentId
            JSONObject userDocumentId=request.getJSONObject("userDocumentId");
            userDocumentId_.setDocumentNumber(userDocumentId.getString("documentNumber"));
            userDocumentId_.setDocumentType(userDocumentId.getString("documentType"));
            userDocumentId_.setIntegrationProperties(userDocumentId.getString("integrationProperties"));
             
            dtoTercero.setClientBankIdentifiers(clientBankIdentifiers_);
            dtoTercero.setThirdPartyProductNumber(thirdPartyProductNumber_);
            dtoTercero.setThirdPartyProductBankIdentifier(thirdPartyProductBankIdentifier_);
            dtoTercero.setAlias(alias_);
            dtoTercero.setCurrencyId(currencyId_);
            dtoTercero.setTransactionSubType(transactionSubType_);
            dtoTercero.setOwnerName(ownerName_);
            dtoTercero.setOwnerCountryId(ownerCountryId_);
            dtoTercero.setOwnerEmail(ownerEmail_);
            dtoTercero.setOwnerCity(ownerCity_);
            dtoTercero.setOwnerCity(ownerCity_);
            dtoTercero.setOwnerAddress(ownerAddress_);
            dtoTercero.setOwnerDocumentId(ownerDocumentId_);
            dtoTercero.setOwnerPhoneNumber(ownerPhoneNumber_);
            dtoTercero.setBank(bank_);
            dtoTercero.setCorrespondentBank(correspondentBank_);
            dtoTercero.setUserDocumentId(userDocumentId_);
            dtoTercero.setThirdPartyProductType(thirdPartyProductType_);
            dtoTercero.setProductType(productType_);
        } catch (Exception e) {
           return Response.status(Response.Status.BAD_GATEWAY).entity(e.getMessage()).build();
        }
        TercerosDAO dao=new TercerosDAO();
        try {
            System.out.println("si");
            BackendOperationResultDTO response= dao.validarProductoTerceros(dtoTercero);
            JsonObject jsonResponse=new JsonObject();
            jsonResponse.put("BackendOperationResult",response);
            return Response.status(Response.Status.OK).entity(jsonResponse).build();
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            e.printStackTrace();
            dao.cerrar();
        }finally{
          dao.cerrar();  
        }
        
        
           
           
        return null;
    }
    
    
    
    @Path("/Party/Account/ProductOwnerAndCurrency")
    @POST
    @Produces({MediaType.APPLICATION_JSON +";charset=utf-8"})
    @Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public Response altaTerceros(String cadena){
         System.out.println("Request Terceros:"+cadena);
         String productNumber_1="";
         Integer productTypeId_1=0;
         
         String documentNumber_="";
         String documentType_="";
         Integer thirdPartyProductType_1=0;
         try {
            JSONObject request=new JSONObject(cadena);
            productNumber_1=request.getString("productNumber");
            productTypeId_1=request.getInt("productTypeId");
            
            //Otengo el objeto de productOwnerDocumentId
            JSONObject productOwnerDocumentId=request.getJSONObject("productOwnerDocumentId");
            documentNumber_=productOwnerDocumentId.getString("documentNumber");
            documentType_=productOwnerDocumentId.getString("documentType");
            //
            thirdPartyProductType_1=request.getInt("thirdPartyProductType");
            
        } catch (Exception e) {
           return Response.status(Response.Status.BAD_GATEWAY).entity(e.getMessage()).build();
        }
        TercerosDAO dao=new TercerosDAO();
        try {
             ThirdPartyProductDTO dto=dao.cosultaProductosTerceros(productNumber_1, productTypeId_1,documentNumber_, documentType_,thirdPartyProductType_1);
             JsonObject third=new JsonObject();
             third.put("productOwnerAndCurrency",dto);
             return Response.status(Response.Status.OK).entity(third).build();
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            e.printStackTrace();
            dao.cerrar();
        }finally{
          dao.cerrar();  
        }
        
        return null;
    }
        
}
