/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.WsTDD;

import java.io.Serializable;
import javax.persistence.Column;

/**
 *
 * @author Elliot
 */
public class SaldoTddPK implements Serializable {

    @Column(name = "idorigenp")
    private int idorigenp;
    @Column(name = "idproducto")
    private int idproducto;
    @Column(name = "idauxiliar")
    private int idauxiliar;

    public SaldoTddPK() {
    }

    public SaldoTddPK(int idorigenp, int idproducto, int idauxiliar) {
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
        if (!(object instanceof SaldoTddPK)) {
            return false;
        }
        SaldoTddPK other = (SaldoTddPK) object;
        if (this.idorigenp != other.idorigenp) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        return this.idauxiliar == other.idauxiliar;
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.SaldoTddPK[ idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + " ]";
    }

}
