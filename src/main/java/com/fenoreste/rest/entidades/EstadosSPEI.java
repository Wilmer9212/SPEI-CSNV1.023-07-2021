/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
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

    public EstadosSPEI() {
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

    @Override
    public String toString() {
        return "EstadosSPEI{" + "idorden=" + idorden + ", empresa=" + empresa + ", folioorigen=" + folioorigen + ", estado=" + estado + ", causadevolucion=" + causadevolucion + '}';
    }
    
    
    
}
