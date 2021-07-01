/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name="loan_fee_statusB")
public class Loan_Fee_Status {
    
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="description")
    private String description;
    @Column(name="descripcion")
    private String descripcion;

    public Loan_Fee_Status() {
    }

    public Loan_Fee_Status(Integer id, String description, String descripcion) {
        this.id = id;
        this.description = description;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Loan_Fee_Status{" + "id=" + id + ", description=" + description + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
}
