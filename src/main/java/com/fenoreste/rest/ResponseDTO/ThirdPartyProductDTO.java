/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

import java.util.ArrayList;

/**
 *
 * @author wilmer
 */
public class ThirdPartyProductDTO {

    ArrayList<String> clientBankIdentifiers;
    String thirdPartyProductNumber;
    String thirdPartyProductBankIdentifier;
    String alias;
    String currencyId;
    Integer transactionSubType;
    Integer thirdPartyProductType;
    Integer productType;
    String ownerName;
    String  ownerCountryId;
    String ownerEmail;
    String ownerCity;
    String ownerAddress;
    userDocumentIdDTO ownerDocumentId;
    String ownerPhoneNumber;
    Bank bank;
    Bank correspondentBank;
    userDocumentIdDTO userDocumentId;

    public ThirdPartyProductDTO() {
    }

    public ThirdPartyProductDTO(ArrayList<String> clientBankIdentifiers, String thirdPartyProductNumber, String thirdPartyProductBankIdentifier, String alias, String currencyId, Integer transactionSubType, Integer thirdPartyProductType, Integer productType, String ownerName, String ownerCountryId, String ownerEmail, String ownerCity, String ownerAddress, userDocumentIdDTO ownerDocumentId, String ownerPhoneNumber, Bank bank, Bank correspondentBank, userDocumentIdDTO userDocumentId) {
        this.clientBankIdentifiers = clientBankIdentifiers;
        this.thirdPartyProductNumber = thirdPartyProductNumber;
        this.thirdPartyProductBankIdentifier = thirdPartyProductBankIdentifier;
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
        this.ownerDocumentId = ownerDocumentId;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.bank = bank;
        this.correspondentBank = correspondentBank;
        this.userDocumentId = userDocumentId;
    }

    public ArrayList<String> getClientBankIdentifiers() {
        return clientBankIdentifiers;
    }

    public void setClientBankIdentifiers(ArrayList<String> clientBankIdentifiers) {
        this.clientBankIdentifiers = clientBankIdentifiers;
    }

    public String getThirdPartyProductNumber() {
        return thirdPartyProductNumber;
    }

    public void setThirdPartyProductNumber(String thirdPartyProductNumber) {
        this.thirdPartyProductNumber = thirdPartyProductNumber;
    }

    public String getThirdPartyProductBankIdentifier() {
        return thirdPartyProductBankIdentifier;
    }

    public void setThirdPartyProductBankIdentifier(String thirdPartyProductBankIdentifier) {
        this.thirdPartyProductBankIdentifier = thirdPartyProductBankIdentifier;
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

    public userDocumentIdDTO getOwnerDocumentId() {
        return ownerDocumentId;
    }

    public void setOwnerDocumentId(userDocumentIdDTO ownerDocumentId) {
        this.ownerDocumentId = ownerDocumentId;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getCorrespondentBank() {
        return correspondentBank;
    }

    public void setCorrespondentBank(Bank correspondentBank) {
        this.correspondentBank = correspondentBank;
    }

    public userDocumentIdDTO getUserDocumentId() {
        return userDocumentId;
    }

    public void setUserDocumentId(userDocumentIdDTO userDocumentId) {
        this.userDocumentId = userDocumentId;
    }

    @Override
    public String toString() {
        return "ThirdPartyProductDTO{" + "clientBankIdentifiers=" + clientBankIdentifiers + ", thirdPartyProductNumber=" + thirdPartyProductNumber + ", thirdPartyProductBankIdentifier=" + thirdPartyProductBankIdentifier + ", alias=" + alias + ", currencyId=" + currencyId + ", transactionSubType=" + transactionSubType + ", thirdPartyProductType=" + thirdPartyProductType + ", productType=" + productType + ", ownerName=" + ownerName + ", ownerCountryId=" + ownerCountryId + ", ownerEmail=" + ownerEmail + ", ownerCity=" + ownerCity + ", ownerAddress=" + ownerAddress + ", ownerDocumentId=" + ownerDocumentId + ", ownerPhoneNumber=" + ownerPhoneNumber + ", bank=" + bank + ", correspondentBank=" + correspondentBank + ", userDocumentId=" + userDocumentId + '}';
    }
    
    
    
    
    
    
    
}
