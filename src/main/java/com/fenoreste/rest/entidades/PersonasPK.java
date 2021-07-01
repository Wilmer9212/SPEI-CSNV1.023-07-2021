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
 * @author Elliot
 */
@Cacheable(false)
@Embeddable
public class PersonasPK implements Serializable {

    @Column(name = "idorigen")
    private int idorigen;
    @Column(name = "idgrupo")
    private int idgrupo;
    @Column(name = "idsocio")
    private int idsocio;

    public PersonasPK() {
    }

    public PersonasPK(int idorigen, int idgrupo, int idsocio) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public int getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(int idsocio) {
        this.idsocio = idsocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idorigen;
        hash += (int) idgrupo;
        hash += (int) idsocio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonasPK)) {
            return false;
        }
        PersonasPK other = (PersonasPK) object;
        if (this.idorigen != other.idorigen) {
            return false;
        }
        if (this.idgrupo != other.idgrupo) {
            return false;
        }
        return this.idsocio == other.idsocio;
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.PersonasPK[ idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + " ]";
    }

}
