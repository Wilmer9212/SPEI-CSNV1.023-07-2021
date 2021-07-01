/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wilmer
 */
@Entity
@Table(name="catalogo_status_bankingly")
public class Catalog_Status_Bankingly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusdb")
    private Integer statusdb;
    @Column(name="productstatusid")
    private Integer productstatusid;
    @Column(name="description")
    private String description;
    @Column(name="descripcion")
    private String descripcion;

    public Catalog_Status_Bankingly() {
    }

    public Catalog_Status_Bankingly(int statusdb, int productstatusid, String description, String descripcion) {
        this.statusdb = statusdb;
        this.productstatusid = productstatusid;
        this.description = description;
        this.descripcion = descripcion;
    }

    public int getStatusdb() {
        return statusdb;
    }

    public void setStatusdb(int statusdb) {
        this.statusdb = statusdb;
    }

    public int getProductstatusid() {
        return productstatusid;
    }

    public void setProductstatusid(int productstatusid) {
        this.productstatusid = productstatusid;
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
        return "Catalog_Status_Bankingly{" + "statusdb=" + statusdb + ", productstatusid=" + productstatusid + ", description=" + description + ", descripcion=" + descripcion + '}';
    }
      
    
}
