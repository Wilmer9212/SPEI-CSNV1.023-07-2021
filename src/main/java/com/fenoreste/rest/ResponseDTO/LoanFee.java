/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

import java.util.Date;

/**
 *
 * @author Elliot
 */
public class LoanFee {
   
private Double capitalBalance;
private Integer feeNumber;
private Double principalAmount;
private String dueDate;
private Double interestAmount;
private Double overdueAmount;
private Integer feeStatusId;
private Double othersAmount;
private Double totalAmount;

    public LoanFee() {
    }

    public LoanFee(Double capitalBalance, Integer feeNumber, Double principalAmount, String dueDate, Double interestAmount, Double overdueAmount, Integer feeStatusId, Double othersAmount, Double totalAmount) {
        this.capitalBalance = capitalBalance;
        this.feeNumber = feeNumber;
        this.principalAmount = principalAmount;
        this.dueDate = dueDate;
        this.interestAmount = interestAmount;
        this.overdueAmount = overdueAmount;
        this.feeStatusId = feeStatusId;
        this.othersAmount = othersAmount;
        this.totalAmount = totalAmount;
    }

    public Double getCapitalBalance() {
        return capitalBalance;
    }

    public void setCapitalBalance(Double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

    public Integer getFeeNumber() {
        return feeNumber;
    }

    public void setFeeNumber(Integer feeNumber) {
        this.feeNumber = feeNumber;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Double getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Double overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Integer getFeeStatusId() {
        return feeStatusId;
    }

    public void setFeeStatusId(Integer feeStatusId) {
        this.feeStatusId = feeStatusId;
    }

    public Double getOthersAmount() {
        return othersAmount;
    }

    public void setOthersAmount(Double othersAmount) {
        this.othersAmount = othersAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "LoanFee{" + "capitalBalance=" + capitalBalance + ", feeNumber=" + feeNumber + ", principalAmount=" + principalAmount + ", dueDate=" + dueDate + ", interestAmount=" + interestAmount + ", overdueAmount=" + overdueAmount + ", feeStatusId=" + feeStatusId + ", othersAmount=" + othersAmount + ", totalAmount=" + totalAmount + '}';
    }



}
