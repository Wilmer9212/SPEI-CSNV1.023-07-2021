/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.dao;

import com.fenoreste.rest.ResponseDTO.BackendOperationResultDTO;
import com.fenoreste.rest.ResponseDTO.Bank;
import com.fenoreste.rest.ResponseDTO.ThirdPartyProductDTO;
import com.fenoreste.rest.ResponseDTO.userDocumentIdDTO;
import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.entidades.Auxiliares;
import com.fenoreste.rest.entidades.Persona;
import com.fenoreste.rest.entidades.PersonasPK;
import com.fenoreste.rest.entidades.Productos;
import com.fenoreste.rest.entidades.ProductosTerceros;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

/**
 *
 * @author wilmer
 */
public abstract class FacadeTerceros<T> {

    EntityManagerFactory emf = null;

    public FacadeTerceros(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }

    public BackendOperationResultDTO validarProductoTerceros(ThirdPartyProductDTO dtoInput) {
        System.out.println("si."+dtoInput.getOwnerDocumentId().getDocumentNumber());
        EntityManager em = emf.createEntityManager();
        BackendOperationResultDTO dtoResult=new BackendOperationResultDTO();
        try {
            String backendMessage="";
            ProductosTerceros productosTerceros = new ProductosTerceros();

            System.out.println("size:" + dtoInput.getClientBankIdentifiers().size());
            boolean b=false;
            ProductosTerceros prod=null;
            for (int i = 0; i < dtoInput.getClientBankIdentifiers().size(); i++) {
                String cvalidar="SELECT * FROM productos_terceros_bankingly WHERE thirdpartyproductbankidentifier='"+dtoInput.getThirdPartyProductBankIdentifier()+"'";
                Query query = em.createNativeQuery(cvalidar,ProductosTerceros.class);
                try{
                prod=(ProductosTerceros) query.getSingleResult();
                }catch(Exception e){
                    System.out.println("Message:"+e.getMessage());    
                }
                if(prod!=null){
                     backendMessage="Error,producto ya esta registrado...";
                     System.out.println("back:"+backendMessage);
                }else{
                    System.out.println("si tambien");
                productosTerceros.setThirdPartyProductBankIdentifier(dtoInput.getThirdPartyProductBankIdentifier());
                productosTerceros.setClientBankIdentifiers(dtoInput.getClientBankIdentifiers().get(i));
                productosTerceros.setThirdPartyProductNumber(dtoInput.getThirdPartyProductNumber());
                productosTerceros.setAlias(dtoInput.getAlias());
                productosTerceros.setCurrencyId(dtoInput.getCurrencyId());
                productosTerceros.setTransactionSubType(dtoInput.getTransactionSubType());
                productosTerceros.setThirdPartyProductType(dtoInput.getThirdPartyProductType());
                productosTerceros.setProductType(dtoInput.getProductType());
                productosTerceros.setOwnerName(dtoInput.getOwnerName());
                productosTerceros.setOwnerCountryId(dtoInput.getOwnerCountryId());
                productosTerceros.setOwnerEmail(dtoInput.getOwnerEmail());
                productosTerceros.setOwnerCity(dtoInput.getOwnerCity());
                productosTerceros.setOwnerAddress(dtoInput.getOwnerAddress());
                productosTerceros.setOwnerDocumentId_integrationProperties(dtoInput.getOwnerDocumentId().getIntegrationProperties());
                productosTerceros.setOwnerDocumentId_documentNumber(dtoInput.getOwnerDocumentId().getDocumentNumber());
                productosTerceros.setOwnerDocumentId_documentType(dtoInput.getOwnerDocumentId().getDocumentType());
                productosTerceros.setOwnerPhoneNumber(dtoInput.getOwnerPhoneNumber());
                productosTerceros.setBank_bankId(dtoInput.getBank().getBankId());
                productosTerceros.setBank_countryId(dtoInput.getBank().getCountryId());
                productosTerceros.setBank_description(dtoInput.getBank().getDescription());
                productosTerceros.setBank_headQuartersAddress(dtoInput.getBank().getHeadQuartersAddress());
                productosTerceros.setBank_routingCode(dtoInput.getBank().getRoutingCode());
                productosTerceros.setCorrespondentBank_bankId(dtoInput.getCorrespondentBank().getBankId());
                productosTerceros.setCorrespondentBank_countryId(dtoInput.getCorrespondentBank().getCountryId());
                productosTerceros.setCorrespondentBank_description(dtoInput.getCorrespondentBank().getDescription());
                productosTerceros.setCorrespondentBank_headQuartersAddress(dtoInput.getCorrespondentBank().getHeadQuartersAddress());
                productosTerceros.setCorrespondentBank_routingCode(dtoInput.getCorrespondentBank().getRoutingCode());
                productosTerceros.setUserDocumentId_documentNumber(dtoInput.getUserDocumentId().getDocumentNumber());
                productosTerceros.setUserDocumentId_documentType(dtoInput.getUserDocumentId().getDocumentType());
                productosTerceros.setUserDocumentId_integrationProperties(dtoInput.getUserDocumentId().getIntegrationProperties());
                  try {
                    if (!em.getTransaction().isActive()) {
                         em.clear();
                         em.getTransaction().begin();
                         em.persist(productosTerceros);
                         
                    }                     
                  em.getTransaction().commit();
                } catch (Exception e) {
                    if (em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                }
                }
                }
                if(i==dtoInput.getClientBankIdentifiers().size()-1 && backendMessage.equals("")){
                    b=true;
                    backendMessage="Producto registrado con exito...";                   
                }
                  
            }
             if(b==true){
                    dtoResult.setBackendCode("1");
                    dtoResult.setBackendMessage(backendMessage);
                    dtoResult.setBackendReference("null");
                    dtoResult.setIntegrationProperties("null");
                    dtoResult.setIsError(false);
                    dtoResult.setTransactionIdenty(productosTerceros.getThirdPartyProductNumber());
                }else{
                    dtoResult.setBackendCode("1");
                    dtoResult.setBackendMessage(backendMessage);
                    dtoResult.setBackendReference("null");
                    dtoResult.setIntegrationProperties("null");
                    dtoResult.setIsError(true);
                    dtoResult.setTransactionIdenty(productosTerceros.getThirdPartyProductNumber());
                
             }
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            System.out.println("Error:" + e.getMessage());
        }
        return dtoResult;

    }

    public ThirdPartyProductDTO cosultaProductosTerceros(String productNumber, Integer productTypeId, String documentNumber, String documentType,Integer thirdPartyProductType) {
        EntityManager em = emf.createEntityManager();
        ThirdPartyProductDTO dto = new ThirdPartyProductDTO();
        try {
            String consulta = "SELECT * FROM productos_terceros_bankingly a WHERE "
                    + "thirdpartyproductnumber='"+productNumber+"' AND producttype=" + productTypeId +" AND "
                    + "ownerdocumentid_documentnumber='"+documentNumber+"' AND ownerdocumentid_documenttype='"+documentType+"'"+
                      " AND thirdpartyproductType="+thirdPartyProductType;
            System.out.println("Consulta:" + consulta);
            Query query = em.createNativeQuery(consulta, ProductosTerceros.class);
            ProductosTerceros pt = (ProductosTerceros) query.getSingleResult();
            
            userDocumentIdDTO document=new userDocumentIdDTO();
            document.setDocumentNumber(pt.getOwnerDocumentId_documentNumber());
            document.setDocumentType(pt.getOwnerDocumentId_documentType());
            document.setIntegrationProperties(pt.getOwnerDocumentId_integrationProperties());
            
            Bank banco=new Bank();
            banco.setBankId(pt.getBank_bankId());
            banco.setCountryId(pt.getBank_countryId());
            banco.setDescription(pt.getBank_description());
            banco.setHeadQuartersAddress(pt.getBank_headQuartersAddress());
            banco.setRoutingCode(pt.getBank_routingCode());
            
            Bank correspondentBank=new Bank();
            correspondentBank.setBankId(pt.getCorrespondentBank_bankId());
            correspondentBank.setCountryId(pt.getCorrespondentBank_countryId());
            correspondentBank.setDescription(pt.getCorrespondentBank_description());
            correspondentBank.setHeadQuartersAddress(pt.getCorrespondentBank_headQuartersAddress());
            correspondentBank.setRoutingCode(pt.getCorrespondentBank_routingCode());
            
            userDocumentIdDTO userDocument=new userDocumentIdDTO();
            userDocument.setDocumentNumber(pt.getUserDocumentId_documentNumber());
            userDocument.setDocumentType(pt.getUserDocumentId_documentType());
            userDocument.setIntegrationProperties(pt.getUserDocumentId_integrationProperties());
                    
            ArrayList<String>listaPt=new ArrayList<>();
            listaPt.add(pt.getClientBankIdentifiers());
            dto.setClientBankIdentifiers(listaPt);
            dto.setThirdPartyProductNumber(pt.getThirdPartyProductNumber());
            dto.setThirdPartyProductBankIdentifier(pt.getThirdPartyProductBankIdentifier());
            dto.setAlias(pt.getAlias());
            dto.setCurrencyId(pt.getCurrencyId());
            dto.setTransactionSubType(pt.getTransactionSubType());
            dto.setThirdPartyProductType(pt.getThirdPartyProductType());
            dto.setProductType(pt.getProductType());
            dto.setOwnerName(pt.getOwnerName());
            dto.setOwnerCountryId(pt.getOwnerCountryId());
            dto.setOwnerEmail(pt.getOwnerEmail());
            dto.setOwnerCity(pt.getOwnerCity());
            dto.setOwnerAddress(pt.getOwnerAddress());
            dto.setOwnerDocumentId(document);
            dto.setOwnerPhoneNumber(pt.getOwnerPhoneNumber());
            dto.setBank(banco);
            dto.setCorrespondentBank(correspondentBank);
            dto.setUserDocumentId(userDocument);
          
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            em.close();
        }
        return dto;

    }

    public void cerrar() {
        emf.close();
    }
}
