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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wilmer
 */
@Entity
@Table(name = "ordenes_spei")
public class OrdenesSPEI implements Serializable {

    @Id   
    private Integer idorden;
    @Column(name = "institucioncontraparte")
    private Integer institucioncontraparte;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "claverastreo")
    private String claverastreo;
    @Column(name = "institucionoperante")
    private Integer institucionoperante;
    @Column(name = "monto")
    private Double monto;
    @Column(name = "tipopago")
    private Integer tipopago;
    @Column(name = "tipocuentaordenante")
    private Integer tipocuentaordenante;
    @Column(name = "nombreordenante")
    private String nombreordenante;
    @Column(name = "cuentaordenante")
    private String cuentaordenante;
    @Column(name = "rfccurpordenante")
    private String rfccurpordenante;
    @Column(name = "tipocuentabeneficiario")
    private Integer tipocuentabeneficiario;
    @Column(name = "nombrebeneficiario")
    private String nombrebeneficiario;
    @Column(name = "cuentabeneficiario")
    private String cuentabeneficiario;
    @Column(name = "rfccurpbeneficiario")
    private String rfccurpbeneficiario;
    @Column(name = "conceptopago")
    private String conceptopago;
    @Column(name = "referencianumerica")
    private Integer referencianumerica;
    @Column(name = "estatus")
    private String estatus;
    @Column(name="fechaejecucion")
    private Timestamp fechaejecucion;

    public OrdenesSPEI() {
    }

    public OrdenesSPEI(Integer idorden, Integer institucioncontraparte, String empresa, String claverastreo, Integer institucionoperante, Double monto, Integer tipopago, Integer tipocuentaordenante, String nombreordenante, String cuentaordenante, String rfccurpordenante, Integer tipocuentabeneficiario, String nombrebeneficiario, String cuentabeneficiario, String rfccurpbeneficiario, String conceptopago, Integer referencianumerica, String estatus, Timestamp fechaejecucion) {
        this.idorden = idorden;
        this.institucioncontraparte = institucioncontraparte;
        this.empresa = empresa;
        this.claverastreo = claverastreo;
        this.institucionoperante = institucionoperante;
        this.monto = monto;
        this.tipopago = tipopago;
        this.tipocuentaordenante = tipocuentaordenante;
        this.nombreordenante = nombreordenante;
        this.cuentaordenante = cuentaordenante;
        this.rfccurpordenante = rfccurpordenante;
        this.tipocuentabeneficiario = tipocuentabeneficiario;
        this.nombrebeneficiario = nombrebeneficiario;
        this.cuentabeneficiario = cuentabeneficiario;
        this.rfccurpbeneficiario = rfccurpbeneficiario;
        this.conceptopago = conceptopago;
        this.referencianumerica = referencianumerica;
        this.estatus = estatus;
        this.fechaejecucion = fechaejecucion;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public Integer getInstitucioncontraparte() {
        return institucioncontraparte;
    }

    public void setInstitucioncontraparte(Integer institucioncontraparte) {
        this.institucioncontraparte = institucioncontraparte;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getClaverastreo() {
        return claverastreo;
    }

    public void setClaverastreo(String claverastreo) {
        this.claverastreo = claverastreo;
    }

    public Integer getInstitucionoperante() {
        return institucionoperante;
    }

    public void setInstitucionoperante(Integer institucionoperante) {
        this.institucionoperante = institucionoperante;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getTipopago() {
        return tipopago;
    }

    public void setTipopago(Integer tipopago) {
        this.tipopago = tipopago;
    }

    public Integer getTipocuentaordenante() {
        return tipocuentaordenante;
    }

    public void setTipocuentaordenante(Integer tipocuentaordenante) {
        this.tipocuentaordenante = tipocuentaordenante;
    }

    public String getNombreordenante() {
        return nombreordenante;
    }

    public void setNombreordenante(String nombreordenante) {
        this.nombreordenante = nombreordenante;
    }

    public String getCuentaordenante() {
        return cuentaordenante;
    }

    public void setCuentaordenante(String cuentaordenante) {
        this.cuentaordenante = cuentaordenante;
    }

    public String getRfccurpordenante() {
        return rfccurpordenante;
    }

    public void setRfccurpordenante(String rfccurpordenante) {
        this.rfccurpordenante = rfccurpordenante;
    }

    public Integer getTipocuentabeneficiario() {
        return tipocuentabeneficiario;
    }

    public void setTipocuentabeneficiario(Integer tipocuentabeneficiario) {
        this.tipocuentabeneficiario = tipocuentabeneficiario;
    }

    public String getNombrebeneficiario() {
        return nombrebeneficiario;
    }

    public void setNombrebeneficiario(String nombrebeneficiario) {
        this.nombrebeneficiario = nombrebeneficiario;
    }

    public String getCuentabeneficiario() {
        return cuentabeneficiario;
    }

    public void setCuentabeneficiario(String cuentabeneficiario) {
        this.cuentabeneficiario = cuentabeneficiario;
    }

    public String getRfccurpbeneficiario() {
        return rfccurpbeneficiario;
    }

    public void setRfccurpbeneficiario(String rfccurpbeneficiario) {
        this.rfccurpbeneficiario = rfccurpbeneficiario;
    }

    public String getConceptopago() {
        return conceptopago;
    }

    public void setConceptopago(String conceptopago) {
        this.conceptopago = conceptopago;
    }

    public Integer getReferencianumerica() {
        return referencianumerica;
    }

    public void setReferencianumerica(Integer referencianumerica) {
        this.referencianumerica = referencianumerica;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Timestamp getFechaejecucion() {
        return fechaejecucion;
    }

    public void setFechaejecucion(Timestamp fechaejecucion) {
        this.fechaejecucion = fechaejecucion;
    }

    @Override
    public String toString() {
        return "OrdenesSPEI{" + "idorden=" + idorden + ", institucioncontraparte=" + institucioncontraparte + ", empresa=" + empresa + ", claverastreo=" + claverastreo + ", institucionoperante=" + institucionoperante + ", monto=" + monto + ", tipopago=" + tipopago + ", tipocuentaordenante=" + tipocuentaordenante + ", nombreordenante=" + nombreordenante + ", cuentaordenante=" + cuentaordenante + ", rfccurpordenante=" + rfccurpordenante + ", tipocuentabeneficiario=" + tipocuentabeneficiario + ", nombrebeneficiario=" + nombrebeneficiario + ", cuentabeneficiario=" + cuentabeneficiario + ", rfccurpbeneficiario=" + rfccurpbeneficiario + ", conceptopago=" + conceptopago + ", referencianumerica=" + referencianumerica + ", estatus=" + estatus + ", fechaejecucion=" + fechaejecucion + '}';
    }
    
    
    
}
