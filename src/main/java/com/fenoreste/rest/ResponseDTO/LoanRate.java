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
public class LoanRate {
    
    private String initialDate;
    private Double rate;

    public LoanRate() {
    }

    public LoanRate(String initialDate, Double rate) {
        this.initialDate = initialDate;
        this.rate = rate;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "LoanRate{" + "initialDate=" + initialDate + ", rate=" + rate + '}';
    }
    
    
}
