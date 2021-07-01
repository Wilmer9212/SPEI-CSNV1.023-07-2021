/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.dao;

import com.fenoreste.rest.ResponseDTO.BackendOperationResultDTO;
import com.fenoreste.rest.ResponseDTO.TransactionToOwnAccountsDTO;
import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.entidades.Auxiliares;
import com.fenoreste.rest.entidades.Productos;
import com.fenoreste.rest.entidades.Transfers;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import sun.swing.BakedArrayList;

/**
 *
 * @author Elliot
 */
public abstract class FacadeTransaction<T> {

    EntityManagerFactory emf;

    public FacadeTransaction(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }

    public BackendOperationResultDTO transferencias(TransactionToOwnAccountsDTO transactionOWN) {
        EntityManager em = emf.createEntityManager();
        Date hoy = new Date();
        String[] arr = new String[2];
        BackendOperationResultDTO backendResult = new BackendOperationResultDTO();
        String messageBackend=comprobarTransferencia(transactionOWN.getDebitProductBankIdentifier(),
                                                     transactionOWN.getCreditProductBankIdentifier(),
                                                     transactionOWN.getAmount(),
                                                     transactionOWN.getSubTransactionTypeId()).toUpperCase();
       
        System.out.println("BackendMessage:"+messageBackend);
        try {
            if(messageBackend.contains("EXITO")){
            Transfers transaction = new Transfers();            
            boolean bandera = false;
            boolean bandera2 = false;
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            transaction.setSubtransactiontypeid(transactionOWN.getSubTransactionTypeId());
            transaction.setCurrencyid(transactionOWN.getCurrencyId());
            transaction.setValuedate(transactionOWN.getValueDate());
            transaction.setTransactiontypeid(transactionOWN.getTransactionTypeId());
            transaction.setTransactionstatusid(transactionOWN.getTransactionStatusId());
            transaction.setClientbankidentifier(transactionOWN.getClientBankIdentifier());
            transaction.setDebitproductbankidentifier(transactionOWN.getDebitProductBankIdentifier());
            transaction.setDebitproducttypeid(transactionOWN.getDebitProductTypeId());
            transaction.setDebitcurrencyid(transactionOWN.getDebitCurrencyId());
            transaction.setCreditproductbankidentifier(transactionOWN.getCreditProductBankIdentifier());
            transaction.setCreditproducttypeid(transactionOWN.getCreditProductTypeId());
            transaction.setCreditcurrencyid(transactionOWN.getCreditCurrencyId());
            transaction.setAmount(transactionOWN.getAmount());
            transaction.setNotifyto(transactionOWN.getNotifyTo());
            transaction.setNotificationchannelid(transactionOWN.getNotificationChannelId());
            transaction.setTransactionid(transactionOWN.getTransactionId());
            transaction.setDestinationname(transactionOWN.getDestinationName());
            transaction.setDestinationbank(transactionOWN.getDestinationBank());
            transaction.setDescription(transactionOWN.getDescription());
            transaction.setBankroutingnumber(transactionOWN.getBankRoutingNumber());
            transaction.setSourcename(transactionOWN.getSourceName());
            transaction.setSourcebank(transactionOWN.getSourceBank());
            transaction.setRegulationamountexceeded(transactionOWN.isRegulationAmountExceeded());
            transaction.setSourcefunds(transactionOWN.getSourceFunds());
            transaction.setDestinationfunds(transactionOWN.getDestinationFunds());
            transaction.setTransactioncost(transactionOWN.getTransactionCost());
            transaction.setTransactioncostcurrencyid(transactionOWN.getTransactionCostCurrencyId());
            transaction.setExchangerate(transactionOWN.getExchangeRate());
            transaction.setFechaejecucion(hoy);
            em.persist(transaction);
            bandera = true;
            tr.commit();
            if (bandera) {
                em.getTransaction().begin();
                em.createNativeQuery("UPDATE auxiliares a SET saldo="
                        + "(SELECT saldo FROM auxiliares WHERE "
                        + "replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getDebitproductbankidentifier() + "')-" + transaction.getAmount()
                        + " WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getDebitproductbankidentifier() + "'").executeUpdate();

                em.createNativeQuery("UPDATE auxiliares a SET saldo="
                        + "(SELECT saldo FROM auxiliares WHERE "
                        + "replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getCreditproductbankidentifier() + "')+" + transaction.getAmount()
                        + " WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getCreditproductbankidentifier() + "'").executeUpdate();
                em.getTransaction().commit();
                bandera2 = true;
            }
            System.out.println("paso");
            String iserror = "", idtransaction = "";

            if (bandera2) {
                idtransaction = String.valueOf(transaction.getTransactionid());
                backendResult.setIsError(false);
                backendResult.setBackendCode("1");
                backendResult.setBackendMessage(messageBackend);
                backendResult.setIntegrationProperties("{}");
                backendResult.setBackendReference(null);
                backendResult.setTransactionIdenty(idtransaction);
            }
            }else {
                backendResult.setIsError(true);
                backendResult.setBackendCode("2");
                backendResult.setBackendMessage(messageBackend);
                backendResult.setIntegrationProperties("{}");
                backendResult.setBackendReference(null);
                backendResult.setTransactionIdenty("0");
                System.out.println("aaaaa");
                return backendResult;
            }
        } catch (Exception e) {
            backendResult.setIsError(true);
            backendResult.setBackendCode("2");
            backendResult.setBackendMessage(e.getMessage());
            backendResult.setIntegrationProperties("{}");
            backendResult.setBackendReference(null);
            backendResult.setTransactionIdenty("0");
            em.close();
            System.out.println("Error al insertar registro:" + e.getMessage());
            return backendResult;
        }
        em.close();
        return backendResult;
    }

    public BackendOperationResultDTO PageToPrestamo(TransactionToOwnAccountsDTO loanPage) {
        EntityManager em = emf.createEntityManager();
        Date hoy = new Date();
        BackendOperationResultDTO backendResult = new BackendOperationResultDTO();
        String backendMessage=comprobarPrestamo(loanPage.getDebitProductBankIdentifier(),
                                                loanPage.getCreditProductBankIdentifier(),
                                                loanPage.getAmount()).toUpperCase();
        System.out.println("BackendMessage:"+backendMessage);
        try {
            if(backendMessage.contains("EXITO")){
            Transfers transaction = new Transfers();
            boolean bandera = false;
            boolean bandera2 = false;
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            transaction.setSubtransactiontypeid(loanPage.getSubTransactionTypeId());
            transaction.setCurrencyid(loanPage.getCurrencyId());
            transaction.setValuedate(loanPage.getValueDate());
            transaction.setTransactiontypeid(loanPage.getTransactionTypeId());
            transaction.setTransactionstatusid(loanPage.getTransactionStatusId());
            transaction.setClientbankidentifier(loanPage.getClientBankIdentifier());
            transaction.setDebitproductbankidentifier(loanPage.getDebitProductBankIdentifier());
            transaction.setDebitproducttypeid(loanPage.getDebitProductTypeId());
            transaction.setDebitcurrencyid(loanPage.getDebitCurrencyId());
            transaction.setCreditproductbankidentifier(loanPage.getCreditProductBankIdentifier());
            transaction.setCreditproducttypeid(loanPage.getCreditProductTypeId());
            transaction.setCreditcurrencyid(loanPage.getCreditCurrencyId());
            transaction.setAmount(loanPage.getAmount());
            transaction.setNotifyto(loanPage.getNotifyTo());
            transaction.setNotificationchannelid(loanPage.getNotificationChannelId());
            transaction.setTransactionid(loanPage.getTransactionId());
            transaction.setDestinationname(loanPage.getDestinationName());
            transaction.setDestinationbank(loanPage.getDestinationBank());
            transaction.setDescription(loanPage.getDescription());
            transaction.setBankroutingnumber(loanPage.getBankRoutingNumber());
            transaction.setSourcename(loanPage.getSourceName());
            transaction.setSourcebank(loanPage.getSourceBank());
            transaction.setRegulationamountexceeded(loanPage.isRegulationAmountExceeded());
            transaction.setSourcefunds(loanPage.getSourceFunds());
            transaction.setDestinationfunds(loanPage.getDestinationFunds());
            transaction.setTransactioncost(loanPage.getTransactionCost());
            transaction.setTransactioncostcurrencyid(loanPage.getTransactionCostCurrencyId());
            transaction.setExchangerate(loanPage.getExchangeRate());
            transaction.setFechaejecucion(hoy);
            em.persist(transaction);
            bandera = true;          
            tr.commit();
            if (bandera) {
                em.getTransaction().begin();
                em.createNativeQuery("UPDATE auxiliares a SET saldo="
                        + "(SELECT saldo FROM auxiliares WHERE "
                        + "replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getDebitproductbankidentifier() + "')-" + transaction.getAmount()
                        + " WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getDebitproductbankidentifier() + "'").executeUpdate();
                
                em.createNativeQuery("UPDATE auxiliares a SET saldo="
                        + "(SELECT saldo FROM auxiliares WHERE "
                        + "replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getCreditproductbankidentifier() + "')-" + transaction.getAmount()
                        + " WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='" + transaction.getCreditproductbankidentifier() + "'").executeUpdate();
                em.getTransaction().commit();
                bandera2 = true;
            }
            String idtransaction = "";
            if (bandera2) {
                idtransaction = String.valueOf(transaction.getTransactionid());
                backendResult.setIsError(false);
                backendResult.setBackendCode("1");
                backendResult.setBackendMessage(backendMessage);
                backendResult.setIntegrationProperties("{}");
                backendResult.setBackendReference(null);
                backendResult.setTransactionIdenty(idtransaction);
            } else {
                backendResult.setIsError(true);
                backendResult.setBackendCode("2");
                backendResult.setBackendMessage(backendMessage);
                backendResult.setIntegrationProperties("{}");
                backendResult.setBackendReference(null);
                backendResult.setTransactionIdenty("0");
            }
        }else{
           backendResult.setIsError(true);
                backendResult.setBackendCode("2");
                backendResult.setBackendMessage(backendMessage);
                backendResult.setIntegrationProperties("{}");
                backendResult.setBackendReference(null);
                backendResult.setTransactionIdenty("0");      
        }
        }catch (Exception e) {
            backendResult.setIsError(true);
            backendResult.setBackendCode("2");
            backendResult.setBackendMessage(e.getMessage());
            backendResult.setIntegrationProperties("{}");
            backendResult.setBackendReference(null);
            backendResult.setTransactionIdenty("0");
            em.close();
            System.out.println("Error al insertar registro:" + e.getMessage());
            return backendResult;
        }
        em.close();
        return backendResult;
    }

    //Busco si el saldo es mayor o igual al que se solicita para la transaccion
    public String comprobarTransferencia(String opa,String opa2, Double monto,int idMov) {
        EntityManager em = emf.createEntityManager();
        String con = "SELECT * FROM auxiliares a WHERE replace(to_char(a.idorigenp,'099999')||to_char(a.idproducto,'09999')||to_char(a.idauxiliar,'09999999'),' ','')='" + opa + "' AND estatus=2";
        String consulta2="SELECT * FROM auxiliares a WHERE replace(to_char(a.idorigenp,'099999')||to_char(a.idproducto,'09999')||to_char(a.idauxiliar,'09999999'),' ','')='" + opa2 + "'";
        String message = "";
        try {
            Query query = em.createNativeQuery(con,Auxiliares.class);
            Auxiliares aux=(Auxiliares) query.getSingleResult();
            Double Saldo = Double.parseDouble(aux.getSaldo().toString());
            Productos pr=em.find(Productos.class,aux.getAuxiliaresPK().getIdproducto());
            if(pr.getTipoproducto()==0){
            if (Saldo >= monto) {
                 Query query2 = em.createNativeQuery(consulta2,Auxiliares.class);
                 Auxiliares aux2=(Auxiliares) query2.getSingleResult();
                 int estatus=aux2.getEstatus();
                 Productos prr=em.find(Productos.class,aux2.getAuxiliaresPK().getIdproducto());
                 switch(idMov){                      
                     case 1:                          
                          if(aux2.getIdorigen()==aux.getIdorigen() &&
                             aux2.getIdgrupo()==aux.getIdgrupo() &&
                             aux2.getIdsocio()==aux.getIdsocio()){
                          if(prr.getTipoproducto()!=2){
                          System.out.println("saldo:" + Saldo+", estatus:"+estatus);
                            if(estatus==2){
                              message="Trasaccion Exitosa";
                            }else{
                              message="Cuenta destino inactiva"; 
                            }
                          }else{
                            message="Prestamo no acepta transferencia";
                          }
                          }else{
                              message="cuenta destino no pertenece al socio";
                          }
                    
                          break;
                     case 2:          
                         if(prr.getTipoproducto()!=2){
                         if(estatus==2){
                              message="Trasaccion Exitosa";
                          }else{
                              message="Cuenta destino inactiva"; 
                          }                          
                         }else{
                             message="Prestamo no acepta transferencia";
                         }
                         break;
                 }                        
            } else {
             message="Fondos insuficientes para completar la transaccion";
            }
            }else{
                message="Producto origen no permite sobrecargos";
            }
        } catch (Exception e) {
            em.close();
            message=e.getMessage();            
            System.out.println("Error en revisar el saldo:" + e.getMessage());
            return message;
        }
        em.close();
        return message.toUpperCase();
    }
    
    public String comprobarPrestamo(String opa,String opa2, Double monto) {
        EntityManager em = emf.createEntityManager();
        String con = "SELECT * FROM auxiliares a WHERE replace(to_char(a.idorigenp,'099999')||to_char(a.idproducto,'09999')||to_char(a.idauxiliar,'09999999'),' ','')='" + opa + "' AND estatus=2";
        String consulta2="SELECT * FROM auxiliares a WHERE replace(to_char(a.idorigenp,'099999')||to_char(a.idproducto,'09999')||to_char(a.idauxiliar,'09999999'),' ','')='" + opa2 + "'";
        String message = "";
        try {
            Query query = em.createNativeQuery(con,Auxiliares.class);
            Auxiliares aux=(Auxiliares) query.getSingleResult();
            Double Saldo = Double.parseDouble(aux.getSaldo().toString());
            Productos pr=em.find(Productos.class,aux.getAuxiliaresPK().getIdproducto());
            if(pr.getTipoproducto()==0){
            if (Saldo >= monto) {
                 Query query2 = em.createNativeQuery(consulta2,Auxiliares.class);
                 Auxiliares aux2=(Auxiliares) query2.getSingleResult();
                 int estatus=aux2.getEstatus();
                 switch(1){                    
                     case 1:     
                      if(aux2.getIdorigen()==aux.getIdorigen() &&
                             aux2.getIdgrupo()==aux.getIdgrupo() &&
                             aux2.getIdsocio()==aux.getIdsocio()){
                     Productos prr=em.find(Productos.class,aux2.getAuxiliaresPK().getIdproducto());
                     if(prr.getTipoproducto()==2){
                     if(estatus==2){
                              message="pago realizado con Exito";
                          }else{
                              message="Cuenta destino inactiva"; 
                          }
                     }else{
                         message="el producto destino no acepta pagos";
                     }                          
                   }else{
                     message="cuenta destino no pertenece al socio";       
                   }
                 break;
                    
                 }                        
            } else {
             message="Fondos insuficientes para completar la transaccion";
            }
            }else{
                message="Producto origen no permite sobrecargos";
            }
        } catch (Exception e) {
            em.close();
            message=e.getMessage();            
            System.out.println("Error en revisar el saldo:" + e.getMessage());
            return message;
        }
        em.close();
        return message.toUpperCase();
    }
    public void cerrar() {
        emf.close();
    }
}
