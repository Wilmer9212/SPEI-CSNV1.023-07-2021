/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class accountsDTO implements Serializable {

    private static final long serialVersionUID = 1L;
     
    private String accountId;
    private String accountType;
    private String balance;
    private String dateActivation;
    
    public accountsDTO() {
    }

    public accountsDTO(String accountId, String accountType, String balance, String dateActivation) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
        this.dateActivation = dateActivation;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(String dateActivation) {
        this.dateActivation = dateActivation;
    }

    @Override
    public String toString() {
        return "accountsDTO{" + "accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance + ", dateActivation=" + dateActivation + '}';
    }

}
