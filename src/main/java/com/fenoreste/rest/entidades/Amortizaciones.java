/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Elliot
 */
@Cacheable(false)
@Entity
@Table(name = "amortizaciones")
public class Amortizaciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected AmortizacionesPK amortizacionesPK;
    @Column(name = "vence")
    @Temporal(TemporalType.DATE)
    private Date vence;
    @Column(name = "abono")
    private BigDecimal abono;
    @Column(name = "io")
    private BigDecimal io;
    @Column(name = "abonopag")
    private BigDecimal abonopag;
    @Column(name = "iopag")
    private BigDecimal iopag;
    @Column(name = "bonificado")
    private Boolean bonificado;
    @Column(name = "pagovariable")
    private Boolean pagovariable;
    @Column(name = "todopag")
    private Boolean todopag;
    @Column(name = "atiempo")
    private Boolean atiempo;
    @Column(name = "bonificacion")
    private BigDecimal bonificacion;
    @Column(name = "anualidad")
    private BigDecimal anualidad;
    @Column(name = "diasvencidos")
    private Integer diasvencidos;

    public Amortizaciones() {
    }

    public Amortizaciones(AmortizacionesPK amortizacionesPK) {
        this.amortizacionesPK = amortizacionesPK;
    }

    public Amortizaciones(int idorigenp, int idproducto, int idauxiliar, int idamortizacion) {
        this.amortizacionesPK = new AmortizacionesPK(idorigenp, idproducto, idauxiliar, idamortizacion);
    }

    public AmortizacionesPK getAmortizacionesPK() {
        return amortizacionesPK;
    }

    public void setAmortizacionesPK(AmortizacionesPK amortizacionesPK) {
        this.amortizacionesPK = amortizacionesPK;
    }

    public Date getVence() {
        return vence;
    }

    public void setVence(Date vence) {
        this.vence = vence;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public BigDecimal getIo() {
        return io;
    }

    public void setIo(BigDecimal io) {
        this.io = io;
    }

    public BigDecimal getAbonopag() {
        return abonopag;
    }

    public void setAbonopag(BigDecimal abonopag) {
        this.abonopag = abonopag;
    }

    public BigDecimal getIopag() {
        return iopag;
    }

    public void setIopag(BigDecimal iopag) {
        this.iopag = iopag;
    }

    public Boolean getBonificado() {
        return bonificado;
    }

    public void setBonificado(Boolean bonificado) {
        this.bonificado = bonificado;
    }

    public Boolean getPagovariable() {
        return pagovariable;
    }

    public void setPagovariable(Boolean pagovariable) {
        this.pagovariable = pagovariable;
    }

    public Boolean getTodopag() {
        return todopag;
    }

    public void setTodopag(Boolean todopag) {
        this.todopag = todopag;
    }

    public Boolean getAtiempo() {
        return atiempo;
    }

    public void setAtiempo(Boolean atiempo) {
        this.atiempo = atiempo;
    }

    public BigDecimal getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(BigDecimal bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getAnualidad() {
        return anualidad;
    }

    public void setAnualidad(BigDecimal anualidad) {
        this.anualidad = anualidad;
    }

    public Integer getDiasvencidos() {
        return diasvencidos;
    }

    public void setDiasvencidos(Integer diasvencidos) {
        this.diasvencidos = diasvencidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amortizacionesPK != null ? amortizacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amortizaciones)) {
            return false;
        }
        Amortizaciones other = (Amortizaciones) object;
        return !((this.amortizacionesPK == null && other.amortizacionesPK != null) || (this.amortizacionesPK != null && !this.amortizacionesPK.equals(other.amortizacionesPK)));
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.Amortizaciones[ amortizacionesPK=" + amortizacionesPK + " ]";
    }

}
