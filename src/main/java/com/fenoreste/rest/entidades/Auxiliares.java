/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "auxiliares")

public class Auxiliares implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AuxiliaresPK auxiliaresPK;
    @Column(name = "idorigen")
    private Integer idorigen;
    @Column(name = "idgrupo")
    private Integer idgrupo;
    @Column(name = "idsocio")
    private Integer idsocio;
    @Column(name = "fechaape")
    @Temporal(TemporalType.DATE)
    private Date fechaape;
    @Column(name = "elaboro")
    private Integer elaboro;
    @Column(name = "autorizo")
    private Integer autorizo;
    @Column(name = "estatus")
    private Short estatus;
    @Column(name = "tasaio")
    private BigDecimal tasaio;
    @Column(name = "tasaim")
    private BigDecimal tasaim;
    @Column(name = "tasaiod")
    private BigDecimal tasaiod;
    @Column(name = "montosolicitado")
    private BigDecimal montosolicitado;
    @Column(name = "montoautorizado")
    private BigDecimal montoautorizado;
    @Column(name = "montoprestado")
    private BigDecimal montoprestado;
    @Column(name = "idfinalidad")
    private Integer idfinalidad;
    @Column(name = "plazo")
    private short plazo;
    @Column(name = "periodoabonos")
    private short periodoabonos;
    @Column(name = "saldoinicial")
    private BigDecimal saldoinicial;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "io")
    private BigDecimal io;
    @Column(name = "idnc")
    private BigDecimal idnc;
    @Column(name = "ieco")
    private BigDecimal ieco;
    @Column(name = "im")
    private BigDecimal im;
    @Column(name = "iva")
    private BigDecimal iva;
    @Column(name = "fechaactivacion")
    @Temporal(TemporalType.DATE)
    private Date fechaactivacion;
    @Column(name = "fechaumi")
    @Temporal(TemporalType.DATE)
    private Date fechaumi;
    @Column(name = "idnotas")
    private String idnotas;
    @Column(name = "tipoprestamo")
    private short tipoprestamo;
    @Column(name = "cartera")
    private String cartera;
    @Column(name = "contaidnc")
    private BigDecimal contaidnc;
    @Column(name = "contaieco")
    private BigDecimal contaieco;
    @Column(name = "reservaidnc")
    private BigDecimal reservaidnc;
    @Column(name = "reservacapital")
    private BigDecimal reservacapital;
    @Column(name = "tipoamortizacion")
    private Short tipoamortizacion;
    @Column(name = "saldodiacum")
    private BigDecimal saldodiacum;
    @Column(name = "fechacartera")
    @Temporal(TemporalType.DATE)
    private Date fechacartera;
    @Column(name = "fechauma")
    @Temporal(TemporalType.DATE)
    private Date fechauma;
    @Column(name = "ivaidnccalc")
    private BigDecimal ivaidnccalc;
    @Column(name = "ivaidncpag")
    private BigDecimal ivaidncpag;
    @Column(name = "tiporeferencia")
    private Short tiporeferencia;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Column(name = "pagodiafijo")
    private Short pagodiafijo;
    @Column(name = "iodif")
    private BigDecimal iodif;
    @Column(name = "garantia")
    private BigDecimal garantia;
    @Column(name = "saldodiacummi")
    private BigDecimal saldodiacummi;
    @Column(name = "comision")
    private BigDecimal comision;
    @Column(name = "fechasdiacum")
    @Temporal(TemporalType.DATE)
    private Date fechasdiacum;
    @Column(name = "prc_comision")
    private BigDecimal prcComision;
    @Column(name = "sobreprecio")
    private BigDecimal sobreprecio;
    @Column(name = "comision_np")
    private BigDecimal comisionNp;
    @Column(name = "pagos_dia_ultimo")
    private Boolean pagosDiaUltimo;
    @Column(name = "tipo_dv")
    private Integer tipoDv;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "fecha_autorizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAutorizacion;
    @Column(name = "idncm")
    private BigDecimal idncm;
    @Column(name = "iecom")
    private BigDecimal iecom;
    @Column(name = "reservaidncm")
    private BigDecimal reservaidncm;

    public Auxiliares() {
    }

    public Auxiliares(AuxiliaresPK auxiliaresPK) {
        this.auxiliaresPK = auxiliaresPK;
    }

    public Auxiliares(int idorigenp, int idproducto, int idauxiliar) {
        this.auxiliaresPK = new AuxiliaresPK(idorigenp, idproducto, idauxiliar);
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

    public AuxiliaresPK getAuxiliaresPK() {
        return auxiliaresPK;
    }

    public void setAuxiliaresPK(AuxiliaresPK auxiliaresPK) {
        this.auxiliaresPK = auxiliaresPK;
    }

    public Date getFechaape() {
        return fechaape;
    }

    public void setFechaape(Date fechaape) {
        this.fechaape = fechaape;
    }

    public Integer getElaboro() {
        return elaboro;
    }

    public void setElaboro(Integer elaboro) {
        this.elaboro = elaboro;
    }

    public Integer getAutorizo() {
        return autorizo;
    }

    public void setAutorizo(Integer autorizo) {
        this.autorizo = autorizo;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getTasaio() {
        return tasaio;
    }

    public void setTasaio(BigDecimal tasaio) {
        this.tasaio = tasaio;
    }

    public BigDecimal getTasaim() {
        return tasaim;
    }

    public void setTasaim(BigDecimal tasaim) {
        this.tasaim = tasaim;
    }

    public BigDecimal getTasaiod() {
        return tasaiod;
    }

    public void setTasaiod(BigDecimal tasaiod) {
        this.tasaiod = tasaiod;
    }

    public BigDecimal getMontosolicitado() {
        return montosolicitado;
    }

    public void setMontosolicitado(BigDecimal montosolicitado) {
        this.montosolicitado = montosolicitado;
    }

    public BigDecimal getMontoautorizado() {
        return montoautorizado;
    }

    public void setMontoautorizado(BigDecimal montoautorizado) {
        this.montoautorizado = montoautorizado;
    }

    public BigDecimal getMontoprestado() {
        return montoprestado;
    }

    public void setMontoprestado(BigDecimal montoprestado) {
        this.montoprestado = montoprestado;
    }

    public Integer getIdfinalidad() {
        return idfinalidad;
    }

    public void setIdfinalidad(Integer idfinalidad) {
        this.idfinalidad = idfinalidad;
    }

    public short getPlazo() {
        return plazo;
    }

    public void setPlazo(short plazo) {
        this.plazo = plazo;
    }

    public short getPeriodoabonos() {
        return periodoabonos;
    }

    public void setPeriodoabonos(short periodoabonos) {
        this.periodoabonos = periodoabonos;
    }

    public BigDecimal getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(BigDecimal saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getIo() {
        return io;
    }

    public void setIo(BigDecimal io) {
        this.io = io;
    }

    public BigDecimal getIdnc() {
        return idnc;
    }

    public void setIdnc(BigDecimal idnc) {
        this.idnc = idnc;
    }

    public BigDecimal getIeco() {
        return ieco;
    }

    public void setIeco(BigDecimal ieco) {
        this.ieco = ieco;
    }

    public BigDecimal getIm() {
        return im;
    }

    public void setIm(BigDecimal im) {
        this.im = im;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Date getFechaactivacion() {
        return fechaactivacion;
    }

    public void setFechaactivacion(Date fechaactivacion) {
        this.fechaactivacion = fechaactivacion;
    }

    public Date getFechaumi() {
        return fechaumi;
    }

    public void setFechaumi(Date fechaumi) {
        this.fechaumi = fechaumi;
    }

    public String getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(String idnotas) {
        this.idnotas = idnotas;
    }

    public short getTipoprestamo() {
        return tipoprestamo;
    }

    public void setTipoprestamo(short tipoprestamo) {
        this.tipoprestamo = tipoprestamo;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

    public BigDecimal getContaidnc() {
        return contaidnc;
    }

    public void setContaidnc(BigDecimal contaidnc) {
        this.contaidnc = contaidnc;
    }

    public BigDecimal getContaieco() {
        return contaieco;
    }

    public void setContaieco(BigDecimal contaieco) {
        this.contaieco = contaieco;
    }

    public BigDecimal getReservaidnc() {
        return reservaidnc;
    }

    public void setReservaidnc(BigDecimal reservaidnc) {
        this.reservaidnc = reservaidnc;
    }

    public BigDecimal getReservacapital() {
        return reservacapital;
    }

    public void setReservacapital(BigDecimal reservacapital) {
        this.reservacapital = reservacapital;
    }

    public Short getTipoamortizacion() {
        return tipoamortizacion;
    }

    public void setTipoamortizacion(Short tipoamortizacion) {
        this.tipoamortizacion = tipoamortizacion;
    }

    public BigDecimal getSaldodiacum() {
        return saldodiacum;
    }

    public void setSaldodiacum(BigDecimal saldodiacum) {
        this.saldodiacum = saldodiacum;
    }

    public Date getFechacartera() {
        return fechacartera;
    }

    public void setFechacartera(Date fechacartera) {
        this.fechacartera = fechacartera;
    }

    public Date getFechauma() {
        return fechauma;
    }

    public void setFechauma(Date fechauma) {
        this.fechauma = fechauma;
    }

    public BigDecimal getIvaidnccalc() {
        return ivaidnccalc;
    }

    public void setIvaidnccalc(BigDecimal ivaidnccalc) {
        this.ivaidnccalc = ivaidnccalc;
    }

    public BigDecimal getIvaidncpag() {
        return ivaidncpag;
    }

    public void setIvaidncpag(BigDecimal ivaidncpag) {
        this.ivaidncpag = ivaidncpag;
    }

    public Short getTiporeferencia() {
        return tiporeferencia;
    }

    public void setTiporeferencia(Short tiporeferencia) {
        this.tiporeferencia = tiporeferencia;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Short getPagodiafijo() {
        return pagodiafijo;
    }

    public void setPagodiafijo(Short pagodiafijo) {
        this.pagodiafijo = pagodiafijo;
    }

    public BigDecimal getIodif() {
        return iodif;
    }

    public void setIodif(BigDecimal iodif) {
        this.iodif = iodif;
    }

    public BigDecimal getGarantia() {
        return garantia;
    }

    public void setGarantia(BigDecimal garantia) {
        this.garantia = garantia;
    }

    public BigDecimal getSaldodiacummi() {
        return saldodiacummi;
    }

    public void setSaldodiacummi(BigDecimal saldodiacummi) {
        this.saldodiacummi = saldodiacummi;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Date getFechasdiacum() {
        return fechasdiacum;
    }

    public void setFechasdiacum(Date fechasdiacum) {
        this.fechasdiacum = fechasdiacum;
    }

    public BigDecimal getPrcComision() {
        return prcComision;
    }

    public void setPrcComision(BigDecimal prcComision) {
        this.prcComision = prcComision;
    }

    public BigDecimal getSobreprecio() {
        return sobreprecio;
    }

    public void setSobreprecio(BigDecimal sobreprecio) {
        this.sobreprecio = sobreprecio;
    }

    public BigDecimal getComisionNp() {
        return comisionNp;
    }

    public void setComisionNp(BigDecimal comisionNp) {
        this.comisionNp = comisionNp;
    }

    public Boolean getPagosDiaUltimo() {
        return pagosDiaUltimo;
    }

    public void setPagosDiaUltimo(Boolean pagosDiaUltimo) {
        this.pagosDiaUltimo = pagosDiaUltimo;
    }

    public Integer getTipoDv() {
        return tipoDv;
    }

    public void setTipoDv(Integer tipoDv) {
        this.tipoDv = tipoDv;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public BigDecimal getIdncm() {
        return idncm;
    }

    public void setIdncm(BigDecimal idncm) {
        this.idncm = idncm;
    }

    public BigDecimal getIecom() {
        return iecom;
    }

    public void setIecom(BigDecimal iecom) {
        this.iecom = iecom;
    }

    public BigDecimal getReservaidncm() {
        return reservaidncm;
    }

    public void setReservaidncm(BigDecimal reservaidncm) {
        this.reservaidncm = reservaidncm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auxiliaresPK != null ? auxiliaresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auxiliares)) {
            return false;
        }
        Auxiliares other = (Auxiliares) object;
        return !((this.auxiliaresPK == null && other.auxiliaresPK != null) || (this.auxiliaresPK != null && !this.auxiliaresPK.equals(other.auxiliaresPK)));
    }

    @Override
    public String toString() {
        return "com.fenoreste.modelo.entidad.Auxiliares[ auxiliaresPK=" + auxiliaresPK + " ]";
    }

}
