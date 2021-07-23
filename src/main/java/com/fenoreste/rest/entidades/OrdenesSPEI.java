/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "estatus1")
    private String estatus1;
    @Column(name = "estatus2")
    private String estatus2;
    @Column(name = "estatus3")
    private String estatus3;
    @Column(name = "estatusfinal")
    private String estatusfinal;

    public OrdenesSPEI() {
    }

    public OrdenesSPEI(Integer idorden, Integer institucioncontraparte, String empresa, String claverastreo, Integer institucionoperante, Double monto, Integer tipopago, Integer tipocuentaordenante, String nombreordenante, String cuentaordenante, String rfccurpordenante, Integer tipocuentabeneficiario, String nombrebeneficiario, String cuentabeneficiario, String rfccurpbeneficiario, String conceptopago, Integer referencianumerica, String estatus1, String estatus2, String estatus3, String estatusfinal) {
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
        this.estatus1 = estatus1;
        this.estatus2 = estatus2;
        this.estatus3 = estatus3;
        this.estatusfinal = estatusfinal;
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

    public String getEstatus1() {
        return estatus1;
    }

    public void setEstatus1(String estatus1) {
        this.estatus1 = estatus1;
    }

    public String getEstatus2() {
        return estatus2;
    }

    public void setEstatus2(String estatus2) {
        this.estatus2 = estatus2;
    }

    public String getEstatus3() {
        return estatus3;
    }

    public void setEstatus3(String estatus3) {
        this.estatus3 = estatus3;
    }

    public String getEstatusfinal() {
        return estatusfinal;
    }

    public void setEstatusfinal(String estatusfinal) {
        this.estatusfinal = estatusfinal;
    }

    
    
}
