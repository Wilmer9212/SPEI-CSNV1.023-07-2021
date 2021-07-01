/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

/**
 *
 * @author Elliot
 */
public class BackendOperationResultDTO {
    
    private String integrationProperties;
    private String backendCode;
    private String backendMessage;
    private String backendReference;
    private boolean isError;
    private String transactionIdenty;

    public BackendOperationResultDTO() {
    }

    public BackendOperationResultDTO(String integrationProperties, String backendCode, String backendMessage, String backendReference, boolean isError, String transactionIdenty) {
        this.integrationProperties = integrationProperties;
        this.backendCode = backendCode;
        this.backendMessage = backendMessage;
        this.backendReference = backendReference;
        this.isError = isError;
        this.transactionIdenty = transactionIdenty;
    }

    public String getIntegrationProperties() {
        return integrationProperties;
    }

    public void setIntegrationProperties(String integrationProperties) {
        this.integrationProperties = integrationProperties;
    }

    public String getBackendCode() {
        return backendCode;
    }

    public void setBackendCode(String backendCode) {
        this.backendCode = backendCode;
    }

    public String getBackendMessage() {
        return backendMessage;
    }

    public void setBackendMessage(String backendMessage) {
        this.backendMessage = backendMessage;
    }

    public String getBackendReference() {
        return backendReference;
    }

    public void setBackendReference(String backendReference) {
        this.backendReference = backendReference;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public String getTransactionIdenty() {
        return transactionIdenty;
    }

    public void setTransactionIdenty(String transactionIdenty) {
        this.transactionIdenty = transactionIdenty;
    }

    @Override
    public String toString() {
        return "BackendOperationResultDTO{" + "integrationProperties=" + integrationProperties + ", backendCode=" + backendCode + ", backendMessage=" + backendMessage + ", backendReference=" + backendReference + ", isError=" + isError + ", transactionIdenty=" + transactionIdenty + '}';
    }
    
    
    
    
    
    
}
