/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wilmer
 */
@Entity
@Table(name="productos_terceros_bankingly")
public class ProductosTerceros implements Serializable{

    @Id
    private String thirdPartyProductBankIdentifier;
    private String clientBankIdentifiers;
    private String thirdPartyProductNumber;
    private String alias;
    private String currencyId;
    private Integer transactionSubType;
    private Integer thirdPartyProductType;
    private Integer productType;
    private String ownerName;
    private String ownerCountryId;
    private String ownerEmail;
    private String ownerCity;
    private String ownerAddress;
    private String ownerDocumentId_integrationProperties;
    private String ownerDocumentId_documentNumber;
    private String ownerDocumentId_documentType;
    private String ownerPhoneNumber;
    private Integer bank_bankId;
    private String bank_description;
    private String bank_routingCode;
    private String bank_countryId;
    private String bank_headQuartersAddress;
    private Integer correspondentBank_bankId;
    private String correspondentBank_description;
    private String correspondentBank_routingCode;
    private String correspondentBank_countryId;
    private String correspondentBank_headQuartersAddress;
    private String userDocumentId_integrationProperties;
    private String userDocumentId_documentNumber;
    private String userDocumentId_documentType;

    public ProductosTerceros() {
    }

    public ProductosTerceros(String thirdPartyProductBankIdentifier, String clientBankIdentifiers, String thirdPartyProductNumber, String alias, String currencyId, Integer transactionSubType, Integer thirdPartyProductType, Integer productType, String ownerName, String ownerCountryId, String ownerEmail, String ownerCity, String ownerAddress, String ownerDocumentId_integrationProperties, String ownerDocumentId_documentNumber, String ownerDocumentId_documentType, String ownerPhoneNumber, Integer bank_bankId, String bank_description, String bank_routingCode, String bank_countryId, String bank_headQuartersAddress, Integer correspondentBank_bankId, String correspondentBank_description, String correspondentBank_routingCode, String correspondentBank_countryId, String correspondentBank_headQuartersAddress, String userDocumentId_integrationProperties, String userDocumentId_documentNumber, String userDocumentId_documentType) {
        this.thirdPartyProductBankIdentifier = thirdPartyProductBankIdentifier;
        this.clientBankIdentifiers = clientBankIdentifiers;
        this.thirdPartyProductNumber = thirdPartyProductNumber;
        this.alias = alias;
        this.currencyId = currencyId;
        this.transactionSubType = transactionSubType;
        this.thirdPartyProductType = thirdPartyProductType;
        this.productType = productType;
        this.ownerName = ownerName;
        this.ownerCountryId = ownerCountryId;
        this.ownerEmail = ownerEmail;
        this.ownerCity = ownerCity;
        this.ownerAddress = ownerAddress;
        this.ownerDocumentId_integrationProperties = ownerDocumentId_integrationProperties;
        this.ownerDocumentId_documentNumber = ownerDocumentId_documentNumber;
        this.ownerDocumentId_documentType = ownerDocumentId_documentType;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.bank_bankId = bank_bankId;
        this.bank_description = bank_description;
        this.bank_routingCode = bank_routingCode;
        this.bank_countryId = bank_countryId;
        this.bank_headQuartersAddress = bank_headQuartersAddress;
        this.correspondentBank_bankId = correspondentBank_bankId;
        this.correspondentBank_description = correspondentBank_description;
        this.correspondentBank_routingCode = correspondentBank_routingCode;
        this.correspondentBank_countryId = correspondentBank_countryId;
        this.correspondentBank_headQuartersAddress = correspondentBank_headQuartersAddress;
        this.userDocumentId_integrationProperties = userDocumentId_integrationProperties;
        this.userDocumentId_documentNumber = userDocumentId_documentNumber;
        this.userDocumentId_documentType = userDocumentId_documentType;
    }

    public String getThirdPartyProductBankIdentifier() {
        return thirdPartyProductBankIdentifier;
    }

    public void setThirdPartyProductBankIdentifier(String thirdPartyProductBankIdentifier) {
        this.thirdPartyProductBankIdentifier = thirdPartyProductBankIdentifier;
    }

    public String getClientBankIdentifiers() {
        return clientBankIdentifiers;
    }

    public void setClientBankIdentifiers(String clientBankIdentifiers) {
        this.clientBankIdentifiers = clientBankIdentifiers;
    }

    public String getThirdPartyProductNumber() {
        return thirdPartyProductNumber;
    }

    public void setThirdPartyProductNumber(String thirdPartyProductNumber) {
        this.thirdPartyProductNumber = thirdPartyProductNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getTransactionSubType() {
        return transactionSubType;
    }

    public void setTransactionSubType(Integer transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    public Integer getThirdPartyProductType() {
        return thirdPartyProductType;
    }

    public void setThirdPartyProductType(Integer thirdPartyProductType) {
        this.thirdPartyProductType = thirdPartyProductType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCountryId() {
        return ownerCountryId;
    }

    public void setOwnerCountryId(String ownerCountryId) {
        this.ownerCountryId = ownerCountryId;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerDocumentId_integrationProperties() {
        return ownerDocumentId_integrationProperties;
    }

    public void setOwnerDocumentId_integrationProperties(String ownerDocumentId_integrationProperties) {
        this.ownerDocumentId_integrationProperties = ownerDocumentId_integrationProperties;
    }

    public String getOwnerDocumentId_documentNumber() {
        return ownerDocumentId_documentNumber;
    }

    public void setOwnerDocumentId_documentNumber(String ownerDocumentId_documentNumber) {
        this.ownerDocumentId_documentNumber = ownerDocumentId_documentNumber;
    }

    public String getOwnerDocumentId_documentType() {
        return ownerDocumentId_documentType;
    }

    public void setOwnerDocumentId_documentType(String ownerDocumentId_documentType) {
        this.ownerDocumentId_documentType = ownerDocumentId_documentType;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Integer getBank_bankId() {
        return bank_bankId;
    }

    public void setBank_bankId(Integer bank_bankId) {
        this.bank_bankId = bank_bankId;
    }

    public String getBank_description() {
        return bank_description;
    }

    public void setBank_description(String bank_description) {
        this.bank_description = bank_description;
    }

    public String getBank_routingCode() {
        return bank_routingCode;
    }

    public void setBank_routingCode(String bank_routingCode) {
        this.bank_routingCode = bank_routingCode;
    }

    public String getBank_countryId() {
        return bank_countryId;
    }

    public void setBank_countryId(String bank_countryId) {
        this.bank_countryId = bank_countryId;
    }

    public String getBank_headQuartersAddress() {
        return bank_headQuartersAddress;
    }

    public void setBank_headQuartersAddress(String bank_headQuartersAddress) {
        this.bank_headQuartersAddress = bank_headQuartersAddress;
    }

    public Integer getCorrespondentBank_bankId() {
        return correspondentBank_bankId;
    }

    public void setCorrespondentBank_bankId(Integer correspondentBank_bankId) {
        this.correspondentBank_bankId = correspondentBank_bankId;
    }

    public String getCorrespondentBank_description() {
        return correspondentBank_description;
    }

    public void setCorrespondentBank_description(String correspondentBank_description) {
        this.correspondentBank_description = correspondentBank_description;
    }

    public String getCorrespondentBank_routingCode() {
        return correspondentBank_routingCode;
    }

    public void setCorrespondentBank_routingCode(String correspondentBank_routingCode) {
        this.correspondentBank_routingCode = correspondentBank_routingCode;
    }

    public String getCorrespondentBank_countryId() {
        return correspondentBank_countryId;
    }

    public void setCorrespondentBank_countryId(String correspondentBank_countryId) {
        this.correspondentBank_countryId = correspondentBank_countryId;
    }

    public String getCorrespondentBank_headQuartersAddress() {
        return correspondentBank_headQuartersAddress;
    }

    public void setCorrespondentBank_headQuartersAddress(String correspondentBank_headQuartersAddress) {
        this.correspondentBank_headQuartersAddress = correspondentBank_headQuartersAddress;
    }

    public String getUserDocumentId_integrationProperties() {
        return userDocumentId_integrationProperties;
    }

    public void setUserDocumentId_integrationProperties(String userDocumentId_integrationProperties) {
        this.userDocumentId_integrationProperties = userDocumentId_integrationProperties;
    }

    public String getUserDocumentId_documentNumber() {
        return userDocumentId_documentNumber;
    }

    public void setUserDocumentId_documentNumber(String userDocumentId_documentNumber) {
        this.userDocumentId_documentNumber = userDocumentId_documentNumber;
    }

    public String getUserDocumentId_documentType() {
        return userDocumentId_documentType;
    }

    public void setUserDocumentId_documentType(String userDocumentId_documentType) {
        this.userDocumentId_documentType = userDocumentId_documentType;
    }

    @Override
    public String toString() {
        return "ProductosTerceros{" + "thirdPartyProductBankIdentifier=" + thirdPartyProductBankIdentifier + ", clientBankIdentifiers=" + clientBankIdentifiers + ", thirdPartyProductNumber=" + thirdPartyProductNumber + ", alias=" + alias + ", currencyId=" + currencyId + ", transactionSubType=" + transactionSubType + ", thirdPartyProductType=" + thirdPartyProductType + ", productType=" + productType + ", ownerName=" + ownerName + ", ownerCountryId=" + ownerCountryId + ", ownerEmail=" + ownerEmail + ", ownerCity=" + ownerCity + ", ownerAddress=" + ownerAddress + ", ownerDocumentId_integrationProperties=" + ownerDocumentId_integrationProperties + ", ownerDocumentId_documentNumber=" + ownerDocumentId_documentNumber + ", ownerDocumentId_documentType=" + ownerDocumentId_documentType + ", ownerPhoneNumber=" + ownerPhoneNumber + ", bank_bankId=" + bank_bankId + ", bank_description=" + bank_description + ", bank_routingCode=" + bank_routingCode + ", bank_countryId=" + bank_countryId + ", bank_headQuartersAddress=" + bank_headQuartersAddress + ", correspondentBank_bankId=" + correspondentBank_bankId + ", correspondentBank_description=" + correspondentBank_description + ", correspondentBank_routingCode=" + correspondentBank_routingCode + ", correspondentBank_countryId=" + correspondentBank_countryId + ", correspondentBank_headQuartersAddress=" + correspondentBank_headQuartersAddress + ", userDocumentId_integrationProperties=" + userDocumentId_integrationProperties + ", userDocumentId_documentNumber=" + userDocumentId_documentNumber + ", userDocumentId_documentType=" + userDocumentId_documentType + '}';
    }
     
   
}
