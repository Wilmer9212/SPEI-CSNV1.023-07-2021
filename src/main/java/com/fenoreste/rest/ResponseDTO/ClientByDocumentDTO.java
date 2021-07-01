/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

/**
 *
 * @author root
 */
public class ClientByDocumentDTO {
       
     private String ClientBankIdentifier;
     private String ClientName;
     private String ClientType;
     private String DocumentId;

    public ClientByDocumentDTO() {
    }

    public ClientByDocumentDTO(String ClientBankIdentifier, String ClientName, String ClientType, String DocumentId) {
        this.ClientBankIdentifier = ClientBankIdentifier;
        this.ClientName = ClientName;
        this.ClientType = ClientType;
        this.DocumentId = DocumentId;
    }

    public String getClientBankIdentifier() {
        return ClientBankIdentifier;
    }

    public void setClientBankIdentifier(String ClientBankIdentifier) {
        this.ClientBankIdentifier = ClientBankIdentifier;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getClientType() {
        return ClientType;
    }

    public void setClientType(String ClientType) {
        this.ClientType = ClientType;
    }

    public String getDocumentId() {
        return DocumentId;
    }

    public void setDocumentId(String DocumentId) {
        this.DocumentId = DocumentId;
    }

    @Override
    public String toString() {
        return "GetClientByDocumentDTO{" + "ClientBankIdentifier=" + ClientBankIdentifier + ", ClientName=" + ClientName + ", ClientType=" + ClientType + ", DocumentId=" + DocumentId + '}';
    }
    
    
        
     
    
}
