/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wilmer
 */
@Entity
@Table(name = "ws_siscoop_clabe_interbancaria")
public class ws_siscoop_clabe_interbancaria implements Serializable {
    
    @EmbeddedId
    private AuxiliaresPK auxiliaresPK;
    @Column(name="clabe")
    private String clabe;
    @Column(name="fecha_hora")
    @Temporal(TemporalType.DATE)
    private Date fecha_hora;
    @Column(name="asignada")
    private boolean asignada;
    @Column(name="activa")
    private boolean activa;
    @Column(name="bloqueada")
    private boolean bloqueada;

    public ws_siscoop_clabe_interbancaria() {
    }

    public ws_siscoop_clabe_interbancaria(AuxiliaresPK auxiliaresPK, String clabe, Timestamp fecha_hora, boolean asignada, boolean activa, boolean bloqueada) {
        this.auxiliaresPK = auxiliaresPK;
        this.clabe = clabe;
        this.fecha_hora = fecha_hora;
        this.asignada = asignada;
        this.activa = activa;
        this.bloqueada = bloqueada;
    }

    public AuxiliaresPK getAuxiliaresPK() {
        return auxiliaresPK;
    }

    public void setAuxiliaresPK(AuxiliaresPK auxiliaresPK) {
        this.auxiliaresPK = auxiliaresPK;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    @Override
    public String toString() {
        return "ws_siscoop_clabe_interbancaria{" + "auxiliaresPK=" + auxiliaresPK + ", clabe=" + clabe + ", fecha_hora=" + fecha_hora + ", asignada=" + asignada + ", activa=" + activa + ", bloqueada=" + bloqueada + '}';
    }
    
    private static final long serialVersionUID = 1L;
}
