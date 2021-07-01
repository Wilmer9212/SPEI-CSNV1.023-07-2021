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
public class LoanPayment {

    private Double capitalBalance;
    private Integer feeNumber;
    private Integer movementType;
    private Double normalInterestAmount;
    private Double othersAmount;
    private Double overdueInterestAmount;
    private String paymentDate;
    private Double principalAmount;
    private Double totalAmount;

    public LoanPayment() {
    }

    public LoanPayment(Double capitalBalance, Integer feeNumber, Integer movementType, Double normalInterestAmount, Double othersAmount, Double overdueInterestAmount, String paymentDate, Double principalAmount, Double totalAmount) {
        this.capitalBalance = capitalBalance;
        this.feeNumber = feeNumber;
        this.movementType = movementType;
        this.normalInterestAmount = normalInterestAmount;
        this.othersAmount = othersAmount;
        this.overdueInterestAmount = overdueInterestAmount;
        this.paymentDate = paymentDate;
        this.principalAmount = principalAmount;
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

    public Integer getMovementType() {
        return movementType;
    }

    public void setMovementType(Integer movementType) {
        this.movementType = movementType;
    }

    public Double getNormalInterestAmount() {
        return normalInterestAmount;
    }

    public void setNormalInterestAmount(Double normalInterestAmount) {
        this.normalInterestAmount = normalInterestAmount;
    }

    public Double getOthersAmount() {
        return othersAmount;
    }

    public void setOthersAmount(Double othersAmount) {
        this.othersAmount = othersAmount;
    }

    public Double getOverdueInterestAmount() {
        return overdueInterestAmount;
    }

    public void setOverdueInterestAmount(Double overdueInterestAmount) {
        this.overdueInterestAmount = overdueInterestAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "LoanPayment{" + "capitalBalance=" + capitalBalance + ", feeNumber=" + feeNumber + ", movementType=" + movementType + ", normalInterestAmount=" + normalInterestAmount + ", othersAmount=" + othersAmount + ", overdueInterestAmount=" + overdueInterestAmount + ", paymentDate=" + paymentDate + ", principalAmount=" + principalAmount + ", totalAmount=" + totalAmount + '}';
    }
      
}
