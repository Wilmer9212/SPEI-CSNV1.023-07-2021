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
public class sourceDocumentIdDTO {
    
        
    private String integrationProperties;
    private String documentNumber;
    private String documentType;

    public sourceDocumentIdDTO() {
    }

    public sourceDocumentIdDTO(String integrationProperties, String documentNumber, String documentType) {
        this.integrationProperties = integrationProperties;
        this.documentNumber = documentNumber;
        this.documentType = documentType;
    }

    public String getIntegrationProperties() {
        return integrationProperties;
    }

    public void setIntegrationProperties(String integrationProperties) {
        this.integrationProperties = integrationProperties;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "destinationDocumentIdDTO{" + "integrationProperties=" + integrationProperties + ", documentNumber=" + documentNumber + ", documentType=" + documentType + '}';
    }
    
}
