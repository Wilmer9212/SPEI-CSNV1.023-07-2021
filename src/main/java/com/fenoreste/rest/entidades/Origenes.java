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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wilmer
 */
@Cacheable(false)
@Entity
@Table(name = "origenes")
public class Origenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idorigen")
    private Integer idorigen;
    @Column(name = "matriz")
    private int matriz;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numeroext")
    private String numeroext;
    @Column(name = "numeroint")
    private String numeroint;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "codigopostal")
    private String codigopostal;
    @Column(name = "estatus")
    private boolean estatus;
    @Column(name = "fechatrabajo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatrabajo;
    @Column(name = "cta_rendimientos")
    private String ctaRendimientos;
    @Column(name = "cta_quebrantos")
    private String ctaQuebrantos;
    @Column(name = "cta_efectivo")
    private String ctaEfectivo;
    @Column(name = "cta_documentos1")
    private String ctaDocumentos1;
    @Column(name = "cta_documentos2")
    private String ctaDocumentos2;
    @Column(name = "cta_documentos3")
    private String ctaDocumentos3;
    @Column(name = "cta_documentos4")
    private String ctaDocumentos4;
    @Column(name = "cta_documentos5")
    private String ctaDocumentos5;
    @Column(name = "enlinea")
    private boolean enlinea;
    @Column(name = "cta_documentos6")
    private String ctaDocumentos6;
    @Column(name = "cta_documentos7")
    private String ctaDocumentos7;

    public Origenes() {
    }

    public Origenes(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public Origenes(Integer idorigen, int matriz, boolean estatus, Date fechatrabajo, boolean enlinea) {
        this.idorigen = idorigen;
        this.matriz = matriz;
        this.estatus = estatus;
        this.fechatrabajo = fechatrabajo;
        this.enlinea = enlinea;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public int getMatriz() {
        return matriz;
    }

    public void setMatriz(int matriz) {
        this.matriz = matriz;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroext() {
        return numeroext;
    }

    public void setNumeroext(String numeroext) {
        this.numeroext = numeroext;
    }

    public String getNumeroint() {
        return numeroint;
    }

    public void setNumeroint(String numeroint) {
        this.numeroint = numeroint;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public Date getFechatrabajo() {
        return fechatrabajo;
    }

    public void setFechatrabajo(Date fechatrabajo) {
        this.fechatrabajo = fechatrabajo;
    }

    public String getCtaRendimientos() {
        return ctaRendimientos;
    }

    public void setCtaRendimientos(String ctaRendimientos) {
        this.ctaRendimientos = ctaRendimientos;
    }

    public String getCtaQuebrantos() {
        return ctaQuebrantos;
    }

    public void setCtaQuebrantos(String ctaQuebrantos) {
        this.ctaQuebrantos = ctaQuebrantos;
    }

    public String getCtaEfectivo() {
        return ctaEfectivo;
    }

    public void setCtaEfectivo(String ctaEfectivo) {
        this.ctaEfectivo = ctaEfectivo;
    }

    public String getCtaDocumentos1() {
        return ctaDocumentos1;
    }

    public void setCtaDocumentos1(String ctaDocumentos1) {
        this.ctaDocumentos1 = ctaDocumentos1;
    }

    public String getCtaDocumentos2() {
        return ctaDocumentos2;
    }

    public void setCtaDocumentos2(String ctaDocumentos2) {
        this.ctaDocumentos2 = ctaDocumentos2;
    }

    public String getCtaDocumentos3() {
        return ctaDocumentos3;
    }

    public void setCtaDocumentos3(String ctaDocumentos3) {
        this.ctaDocumentos3 = ctaDocumentos3;
    }

    public String getCtaDocumentos4() {
        return ctaDocumentos4;
    }

    public void setCtaDocumentos4(String ctaDocumentos4) {
        this.ctaDocumentos4 = ctaDocumentos4;
    }

    public String getCtaDocumentos5() {
        return ctaDocumentos5;
    }

    public void setCtaDocumentos5(String ctaDocumentos5) {
        this.ctaDocumentos5 = ctaDocumentos5;
    }

    public boolean getEnlinea() {
        return enlinea;
    }

    public void setEnlinea(boolean enlinea) {
        this.enlinea = enlinea;
    }

    public String getCtaDocumentos6() {
        return ctaDocumentos6;
    }

    public void setCtaDocumentos6(String ctaDocumentos6) {
        this.ctaDocumentos6 = ctaDocumentos6;
    }

    public String getCtaDocumentos7() {
        return ctaDocumentos7;
    }

    public void setCtaDocumentos7(String ctaDocumentos7) {
        this.ctaDocumentos7 = ctaDocumentos7;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorigen != null ? idorigen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origenes)) {
            return false;
        }
        Origenes other = (Origenes) object;
        return !((this.idorigen == null && other.idorigen != null) || (this.idorigen != null && !this.idorigen.equals(other.idorigen)));
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.Origenes[ idorigen=" + idorigen + " ]";
    }

}
