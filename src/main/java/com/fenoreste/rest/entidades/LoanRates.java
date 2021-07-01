/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "loanrates")
public class LoanRates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_usuarios_bankingly")
    @SequenceGenerator(name = "sec_usuarios_bankingly", sequenceName = "sec_usuarios_bankingly")
    private Integer id;
    @Column(name="opa")
    private String opa;
    @Column(name="initialdate")
    private String initialdate;
    @Column(name="rate")
    private Double rate;

    public LoanRates() {
    }

    public LoanRates(int id, String opa, String initialdate, Double rate) {
        this.id = id;
        this.opa = opa;
        this.initialdate = initialdate;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpa() {
        return opa;
    }

    public void setOpa(String opa) {
        this.opa = opa;
    }

    public String getInitialdate() {
        return initialdate;
    }

    public void setInitialdate(String initialdate) {
        this.initialdate = initialdate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "LoanRates{" + "id=" + id + ", opa=" + opa + ", initialdate=" + initialdate + ", rate=" + rate + '}';
    }

    
    
    
    
}
