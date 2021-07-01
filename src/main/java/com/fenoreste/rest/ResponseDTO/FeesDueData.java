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
public class FeesDueData {

    private Double FeesDueInterestAmount;
    private Double FeesDueOthersAmount;
    private Double FeesDueOverdueAmount;
    private Double FeesDuePrincipalAmount;
    private Double FeesDueTotalAmount;

    public FeesDueData() {
    }

    public FeesDueData(Double FeesDueInterestAmount, Double FeesDueOthersAmount, Double FeesDueOverdueAmount, Double FeesDuePrincipalAmount, Double FeesDueTotalAmount) {
        this.FeesDueInterestAmount = FeesDueInterestAmount;
        this.FeesDueOthersAmount = FeesDueOthersAmount;
        this.FeesDueOverdueAmount = FeesDueOverdueAmount;
        this.FeesDuePrincipalAmount = FeesDuePrincipalAmount;
        this.FeesDueTotalAmount = FeesDueTotalAmount;
    }

    public Double getFeesDueInterestAmount() {
        return FeesDueInterestAmount;
    }

    public void setFeesDueInterestAmount(Double FeesDueInterestAmount) {
        this.FeesDueInterestAmount = FeesDueInterestAmount;
    }

    public Double getFeesDueOthersAmount() {
        return FeesDueOthersAmount;
    }

    public void setFeesDueOthersAmount(Double FeesDueOthersAmount) {
        this.FeesDueOthersAmount = FeesDueOthersAmount;
    }

    public Double getFeesDueOverdueAmount() {
        return FeesDueOverdueAmount;
    }

    public void setFeesDueOverdueAmount(Double FeesDueOverdueAmount) {
        this.FeesDueOverdueAmount = FeesDueOverdueAmount;
    }

    public Double getFeesDuePrincipalAmount() {
        return FeesDuePrincipalAmount;
    }

    public void setFeesDuePrincipalAmount(Double FeesDuePrincipalAmount) {
        this.FeesDuePrincipalAmount = FeesDuePrincipalAmount;
    }

    public Double getFeesDueTotalAmount() {
        return FeesDueTotalAmount;
    }

    public void setFeesDueTotalAmount(Double FeesDueTotalAmount) {
        this.FeesDueTotalAmount = FeesDueTotalAmount;
    }

    @Override
    public String toString() {
        return "FeesDueData{" + "FeesDueInterestAmount=" + FeesDueInterestAmount + ", FeesDueOthersAmount=" + FeesDueOthersAmount + ", FeesDueOverdueAmount=" + FeesDueOverdueAmount + ", FeesDuePrincipalAmount=" + FeesDuePrincipalAmount + ", FeesDueTotalAmount=" + FeesDueTotalAmount + '}';
    }
    
    
    
    

}
