/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wilmer
 */
@Entity
@Table(name="estados_ordenes_spei")
public class EstadosSPEI implements Serializable{
    
    @Id
    @Column(name="idorden")
    private int idorden;
    private String empresa;
    private String folioorigen;
    private String estado;
    private String causadevolucion;
    private Timestamp fhoraaplicado;

    public EstadosSPEI() {
    }

    public EstadosSPEI(int idorden, String empresa, String folioorigen, String estado, String causadevolucion, Timestamp fhoraaplicado) {
        this.idorden = idorden;
        this.empresa = empresa;
        this.folioorigen = folioorigen;
        this.estado = estado;
        this.causadevolucion = causadevolucion;
        this.fhoraaplicado = fhoraaplicado;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFolioorigen() {
        return folioorigen;
    }

    public void setFolioorigen(String folioorigen) {
        this.folioorigen = folioorigen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCausadevolucion() {
        return causadevolucion;
    }

    public void setCausadevolucion(String causadevolucion) {
        this.causadevolucion = causadevolucion;
    }

    public Timestamp getFhoraaplicado() {
        return fhoraaplicado;
    }

    public void setFhoraaplicado(Timestamp fhoraaplicado) {
        this.fhoraaplicado = fhoraaplicado;
    }

   
    
    
}
