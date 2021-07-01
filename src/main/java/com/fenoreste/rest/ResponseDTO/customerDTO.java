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
public class customerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String customerId;
    private String name;
    private String customerType;

    public customerDTO() {
    }

    public customerDTO(String customerId, String name, String customerType) {
        this.customerId = customerId;
        this.name = name;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "customerDTO{" + "customerId=" + customerId + ", name=" + name + ", customerType=" + customerType + '}';
    }
    
    
    
}
