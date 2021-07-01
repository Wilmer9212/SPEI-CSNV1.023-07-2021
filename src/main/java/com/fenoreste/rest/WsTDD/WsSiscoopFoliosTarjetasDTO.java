/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.WsTDD;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elliot
 */
@XmlRootElement(name = "wsSiscoopFoliosTarjetas")
public class WsSiscoopFoliosTarjetasDTO implements Serializable {

    protected WsSiscoopFoliosTarjetasPK wsSiscoopFoliosTarjetasPK;
    private Boolean asignada;
    private Boolean activa;
    private Boolean bloqueada;

    public WsSiscoopFoliosTarjetasDTO() {
    }

    public WsSiscoopFoliosTarjetasPK getWsSiscoopFoliosTarjetasPK() {
        return wsSiscoopFoliosTarjetasPK;
    }

    public void setWsSiscoopFoliosTarjetasPK(WsSiscoopFoliosTarjetasPK wsSiscoopFoliosTarjetasPK) {
        this.wsSiscoopFoliosTarjetasPK = wsSiscoopFoliosTarjetasPK;
    }

    public Boolean getAsignada() {
        return asignada;
    }

    public void setAsignada(Boolean asignada) {
        this.asignada = asignada;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(Boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.wsSiscoopFoliosTarjetasPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WsSiscoopFoliosTarjetasDTO other = (WsSiscoopFoliosTarjetasDTO) obj;
        return Objects.equals(this.wsSiscoopFoliosTarjetasPK, other.wsSiscoopFoliosTarjetasPK);
    }

    @Override
    public String toString() {
        return "WsSiscoopFoliosTarjetasDTO{" + "wsSiscoopFoliosTarjetasPK=" + wsSiscoopFoliosTarjetasPK + ", asignada=" + asignada + ", activa=" + activa + ", bloqueada=" + bloqueada + '}';
    }

}

