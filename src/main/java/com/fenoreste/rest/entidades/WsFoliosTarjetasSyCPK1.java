/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Elliot
 */
@Cacheable(false)
@Embeddable
public class WsFoliosTarjetasSyCPK1 implements Serializable {

    @Column(name = "idorigenp")
    private int idorigenp;
    @Column(name = "idproducto")
    private int idproducto;
    @Column(name = "idauxiliar")
    private int idauxiliar;

    public WsFoliosTarjetasSyCPK1() {
    }

    public WsFoliosTarjetasSyCPK1(int idorigenp, int idproducto, int idauxiliar) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
    }

    public int getIdorigenp() {
        return idorigenp;
    }

    public void setIdorigenp(int idorigenp) {
        this.idorigenp = idorigenp;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdauxiliar() {
        return idauxiliar;
    }

    public void setIdauxiliar(int idauxiliar) {
        this.idauxiliar = idauxiliar;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idorigenp;
        hash += (int) idproducto;
        hash += (int) idauxiliar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WsFoliosTarjetasSyCPK1)) {
            return false;
        }
        WsFoliosTarjetasSyCPK1 other = (WsFoliosTarjetasSyCPK1) object;
        if (this.idorigenp != other.idorigenp) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idauxiliar != other.idauxiliar) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.WsSiscoopFoliosTarjetasPK[ idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar  + " ]";
    }

}

