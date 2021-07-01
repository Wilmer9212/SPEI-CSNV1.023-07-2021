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
public class LoanFeeDTO {
    
    private LoanFee loanFee;

    public LoanFeeDTO() {
    }

    public LoanFeeDTO(LoanFee loanFee) {
        this.loanFee = loanFee;
    }

    @Override
    public String toString() {
        return "LoanFeeDTO{" + "loanFee=" + loanFee + '}';
    }
    
    
    
}
