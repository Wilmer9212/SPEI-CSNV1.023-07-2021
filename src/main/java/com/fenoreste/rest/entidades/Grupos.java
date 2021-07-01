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
@Table(name="grupos")
public class Grupos implements Serializable{
     
    @Id
    @Column(name="idgrupo")
    private int idgrupo;
    @Column(name="nombre")
    private String nombre;
    @Column(name="tipogrupo")
    private String tipogrupo;

    public Grupos() {
    }

    public Grupos(int idgrupo, String nombre, String tipogrupo) {
        this.idgrupo = idgrupo;
        this.nombre = nombre;
        this.tipogrupo = tipogrupo;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipogrupo() {
        return tipogrupo;
    }

    public void setTipogrupo(String tipogrupo) {
        this.tipogrupo = tipogrupo;
    }

    @Override
    public String toString() {
        return "Grupos{" + "idgrupo=" + idgrupo + ", nombre=" + nombre + ", tipogrupo=" + tipogrupo + '}';
    }
    
    
    
    
    
}
