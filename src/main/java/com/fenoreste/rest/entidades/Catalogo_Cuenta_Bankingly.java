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
@Table(name = "tipos_cuenta_bankingly")
public class Catalogo_Cuenta_Bankingly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Integer idproducto;    
    @Column(name="producttypename")    
    private String productTypeName;
    @Column(name="descripcion")    
    private String descripcion;
    @Column(name="producttypeid")
    private Integer productTypeId;
    public Catalogo_Cuenta_Bankingly() {
    }

    public Catalogo_Cuenta_Bankingly(Integer productTypeId, String productTypeName, String descripcion, Integer idproducto) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.descripcion = descripcion;
        this.idproducto = idproducto;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public String toString() {
        return "Catalogo_Cuenta_Bankingly{" + "productTypeId=" + productTypeId + ", productTypeName=" + productTypeName + ", descripcion=" + descripcion + ", idproducto=" + idproducto + '}';
    }
    
}