/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author wilmer
 */
@Cacheable(false)
@Embeddable
public class SaiSeguroHipotecarioPK implements Serializable {

    @Column(name = "idorigenpr")
    private int idorigenpr;
    @Column(name = "idproductor")
    private int idproductor;
    @Column(name = "idauxiliarr")
    private int idauxiliarr;

    public SaiSeguroHipotecarioPK() {
    }

    public SaiSeguroHipotecarioPK(int idorigenpr, int idproductor, int idauxiliarr) {
        this.idorigenpr = idorigenpr;
        this.idproductor = idproductor;
        this.idauxiliarr = idauxiliarr;
    }

    public int getIdorigenpr() {
        return idorigenpr;
    }

    public void setIdorigenpr(int idorigenpr) {
        this.idorigenpr = idorigenpr;
    }

    public int getIdproductor() {
        return idproductor;
    }

    public void setIdproductor(int idproductor) {
        this.idproductor = idproductor;
    }

    public int getIdauxiliarr() {
        return idauxiliarr;
    }

    public void setIdauxiliarr(int idauxiliarr) {
        this.idauxiliarr = idauxiliarr;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idorigenpr;
        hash = 53 * hash + this.idproductor;
        hash = 53 * hash + this.idauxiliarr;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SaiSeguroHipotecarioPK other = (SaiSeguroHipotecarioPK) obj;
        if (this.idorigenpr != other.idorigenpr) {
            return false;
        }
        if (this.idproductor != other.idproductor) {
            return false;
        }
        return this.idauxiliarr == other.idauxiliarr;
    }

    @Override
    public String toString() {
        return "SaiSeguroHipotecarioPK{" + "idorigenpr=" + idorigenpr + ", idproductor=" + idproductor + ", idauxiliarr=" + idauxiliarr + '}';
    }

}
