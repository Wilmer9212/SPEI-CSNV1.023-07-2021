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
@Table(name="clave_instituciones")
public class Bancos implements Serializable{
    @Id
    @Column(name="idbanco")
    private Integer idbanco;
    @Column(name="nombre")
    private String nombre;

    public Bancos() {
    }

    public Bancos(Integer idbanco, String nombre) {
        this.idbanco = idbanco;
        this.nombre = nombre;
    }
    
    

    public Integer getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Integer idbanco) {
        this.idbanco = idbanco;
    }
     
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Bancos{" + "id=" + idbanco + ", nombre=" + nombre + '}';
    }

    private static final long serialVersionUID = 1L;
    
    
}
