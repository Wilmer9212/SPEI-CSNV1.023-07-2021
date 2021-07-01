/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Elliot
 */
@Embeddable
public class AuxiliaresPK implements Serializable {

    @Column(name = "idorigenp", nullable = false)
    private Integer idorigenp;
    @Column(name = "idproducto")
    private Integer idproducto;
    @Column(name = "idauxiliar")
    private Integer idauxiliar;

    public AuxiliaresPK() {
    }

    public AuxiliaresPK(Integer idorigenp, Integer idproducto, Integer idauxiliar) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
    }

    public Integer getIdorigenp() {
        return idorigenp;
    }

    public void setIdorigenp(Integer idorigenp) {
        this.idorigenp = idorigenp;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdauxiliar() {
        return idauxiliar;
    }

    public void setIdauxiliar(Integer idauxiliar) {
        this.idauxiliar = idauxiliar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idorigenp);
        hash = 67 * hash + Objects.hashCode(this.idproducto);
        hash = 67 * hash + Objects.hashCode(this.idauxiliar);
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
        final AuxiliaresPK other = (AuxiliaresPK) obj;
        if (!Objects.equals(this.idorigenp, other.idorigenp)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        if (!Objects.equals(this.idauxiliar, other.idauxiliar)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.AuxiliaresPK[ idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + " ]";
    }

}
