/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Elliot
 */
@Embeddable
public class AmortizacionesPK implements Serializable {

    @Column(name = "idorigenp")
    private int idorigenp;
    @Column(name = "idproducto")
    private int idproducto;
    @Column(name = "idauxiliar")
    private int idauxiliar;
    @Column(name = "idamortizacion")
    private int idamortizacion;

    public AmortizacionesPK() {
    }

    public AmortizacionesPK(int idorigenp, int idproducto, int idauxiliar) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
    }

    public AmortizacionesPK(int idorigenp, int idproducto, int idauxiliar, int idamortizacion) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
        this.idamortizacion = idamortizacion;
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

    public int getIdamortizacion() {
        return idamortizacion;
    }

    public void setIdamortizacion(int idamortizacion) {
        this.idamortizacion = idamortizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idorigenp;
        hash += (int) idproducto;
        hash += (int) idauxiliar;
        hash += (int) idamortizacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmortizacionesPK)) {
            return false;
        }
        AmortizacionesPK other = (AmortizacionesPK) object;
        if (this.idorigenp != other.idorigenp) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        if (this.idauxiliar != other.idauxiliar) {
            return false;
        }
        return this.idamortizacion == other.idamortizacion;
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.AmortizacionesPK[ idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", idamortizacion=" + idamortizacion + " ]";
    }

}
