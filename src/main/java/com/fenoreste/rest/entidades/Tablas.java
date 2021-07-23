/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Elliot
 */
@Cacheable(false)
@Entity
@Table(name = "tablas")
public class Tablas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TablasPK tablasPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dato1")
    private String dato1;
    @Column(name = "dato2")
    private String dato2;
    @Column(name = "dato3")
    private String dato3;
    @Column(name = "dato4")
    private String dato4;
    @Column(name = "dato5")
    private String dato5;
    @Column(name = "tipo")
    private short tipo;

    public Tablas() {
    }

    public Tablas(TablasPK tablasPK) {
        this.tablasPK = tablasPK;
    }

    public Tablas(TablasPK tablasPK, short tipo) {
        this.tablasPK = tablasPK;
        this.tipo = tipo;
    }

    public Tablas(String idtabla, String idelemento) {
        this.tablasPK = new TablasPK(idtabla, idelemento);
    }

    public TablasPK getTablasPK() {
        return tablasPK;
    }

    public void setTablasPK(TablasPK tablasPK) {
        this.tablasPK = tablasPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    public String getDato3() {
        return dato3;
    }

    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }

    public String getDato4() {
        return dato4;
    }

    public void setDato4(String dato4) {
        this.dato4 = dato4;
    }

    public String getDato5() {
        return dato5;
    }

    public void setDato5(String dato5) {
        this.dato5 = dato5;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablasPK != null ? tablasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tablas)) {
            return false;
        }
        Tablas other = (Tablas) object;
        return !((this.tablasPK == null && other.tablasPK != null) || (this.tablasPK != null && !this.tablasPK.equals(other.tablasPK)));
    }

    @Override
    public String toString() {
        return "com.fenoreste.ws.rest.modelos.entidad.Tablas[ tablasPK=" + tablasPK + " ]";
    }


}
