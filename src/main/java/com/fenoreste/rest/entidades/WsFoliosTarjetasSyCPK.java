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
public class WsFoliosTarjetasSyCPK implements Serializable {

    @Column(name = "idorigenp")
    private int idorigenp;
    @Column(name = "idproducto")
    private int idproducto;
    @Column(name = "idauxiliar")
    private int idauxiliar;
    @Column(name = "idtarjeta")
    private String idtarjeta;
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    public WsFoliosTarjetasSyCPK() {
    }

    public WsFoliosTarjetasSyCPK(int idorigenp, int idproducto, int idauxiliar, String idtarjeta, Date fechaHora) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
        this.idtarjeta = idtarjeta;
        this.fechaHora = fechaHora;
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

    public String getIdtarjeta() {
        return idtarjeta;
    }

    public void setIdtarjeta(String idtarjeta) {
        this.idtarjeta = idtarjeta;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idorigenp;
        hash += (int) idproducto;
        hash += (int) idauxiliar;
        hash += (idtarjeta != null ? idtarjeta.hashCode() : 0);
        hash += (fechaHora != null ? fechaHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WsFoliosTarjetasSyCPK)) {
            return false;
        }
        WsFoliosTarjetasSyCPK other = (WsFoliosTarjetasSyCPK) object;
        if (this.idorigenp != other.idorigenp) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idauxiliar != other.idauxiliar) {
            return false;
        }
        if ((this.idtarjeta == null && other.idtarjeta != null) || (this.idtarjeta != null && !this.idtarjeta.equals(other.idtarjeta))) {
            return false;
        }
        return !((this.fechaHora == null && other.fechaHora != null) || (this.fechaHora != null && !this.fechaHora.equals(other.fechaHora)));
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.WsSiscoopFoliosTarjetasPK[ idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", idtarjeta=" + idtarjeta + ", fechaHora=" + fechaHora + " ]";
    }

}

