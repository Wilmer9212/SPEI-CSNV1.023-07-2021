package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos{

	@Id
	@Column(name="idproducto")
	private Integer idproducto;
	@Column
	private String nombre;
	@Column 
	private Integer idorigen;
	@Column
	private String cuentaaplica;
	@Column 
	private String cuentavencida;
	@Column
	private String cuentaintord;
	@Column
	private String cuentaidnc;
	@Column 
        private String cuentaidncv;
	@Column
	private String cuentaidncres;
	@Column 
	private String cuentaoiod;
	@Column 
	private String cuentaintmor;
	@Column 
	private String cuentaiva;
	@Column 
	private String cuentarc;
	@Column 
	private String cuentari;
	@Column 
	private Integer tipoproducto;
	@Column
	 private Integer tiporetiro;             
	 @Column
	 private Integer tipocalculo            ;
	 @Column
	 private Integer tasaio                 ;
	 @Column
	 private Integer tasaiod                ;
	 @Column
	 private Integer tasaim                 ;
	 @Column
	 private Integer iva                    ;
	 @Column
	 private Integer ivaim                  ;
	 @Column
	 private Integer garantias              ;
	 @Column
	 private Integer avales                 ;
	 @Column
	 private Boolean reqsocio               ;
	 @Column
	 private Integer tipoamortizacion       ;
	 @Column
	 private Integer maxeventos             ;
	 @Column
	 private Integer maxdv                  ;
	 @Column
	 private String saldominimo            ;
	 @Column
	 private String saldomaximo            ;
	 @Column
	 private String cuentageprcc           ;
	 @Column
	 private String cuentageprci           ;
	 @Column
	 private String cuentaeprcc            ;
	 @Column
	 private String cuentaeprci            ;
	 @Column
	 private String cuentaoimd             ;
	 @Column
	 private String cuentaoima             ;
	 @Column
	 private String cuentaoioa             ;
	 @Column
	 private String cuentaivaim            ;
	 @Column
	 private String cuentaivaidncvig       ;
	 @Column
	 private String cuentaivaidncven       ;
	 @Column
	 private String cuentaivappidnc        ;
	 @Column
	 private String cuentaintordv          ;
	 @Column
	 private Integer plazomax               ;
	 @Column
	 private Integer tipofinalidad          ;
	 @Column
	 private String activo                 ;
	 @Column
	 private String pagodiafijo            ;
	 @Column
	 private String cant_aperturas         ;
	 @Column
	 private Integer producto_padre         ;
	 @Column
	 private Integer tasasp                 ;
	 @Column
	 private Integer ivasp                  ;
	 @Column
	 private String cuentasp               ;
	 @Column
	 private String cuentaivasp            ;
	 @Column
	 private String tolerancia_im          ;
	 @Column
	 private String tolerancia_com_no_pago ;
	 @Column
	 private Double monto_com_no_pago      ;
	 @Column
	 private Double comision_apertura      ;
	 @Column
	 private String rango_edad             ;
	 @Column
	 private String evalua_aperturas       ;
	 @Column
	 private String cuentaintmorv          ;
	 @Column
	 private String cuentaidncmres         ;
	 @Column
	 private String cuentaidncm            ;
	 @Column
	 private String cuentaidncmv           ;
	 @Column
	 private String cuentageprcim          ;
	 @Column
	 private String cuentaeprcim ;  	
	
	
	public Productos() {
		
	}

    public Productos(Integer idproducto, String nombre, Integer idorigen, String cuentaaplica, String cuentavencida, String cuentaintord, String cuentaidnc, String cuentaidncv, String cuentaidncres, String cuentaoiod, String cuentaintmor, String cuentaiva, String cuentarc, String cuentari, Integer tipoproducto, Integer tiporetiro, Integer tipocalculo, Integer tasaio, Integer tasaiod, Integer tasaim, Integer iva, Integer ivaim, Integer garantias, Integer avales, Boolean reqsocio, Integer tipoamortizacion, Integer maxeventos, Integer maxdv, String saldominimo, String saldomaximo, String cuentageprcc, String cuentageprci, String cuentaeprcc, String cuentaeprci, String cuentaoimd, String cuentaoima, String cuentaoioa, String cuentaivaim, String cuentaivaidncvig, String cuentaivaidncven, String cuentaivappidnc, String cuentaintordv, Integer plazomax, Integer tipofinalidad, String activo, String pagodiafijo, String cant_aperturas, Integer producto_padre, Integer tasasp, Integer ivasp, String cuentasp, String cuentaivasp, String tolerancia_im, String tolerancia_com_no_pago, Double monto_com_no_pago, Double comision_apertura, String rango_edad, String evalua_aperturas, String cuentaintmorv, String cuentaidncmres, String cuentaidncm, String cuentaidncmv, String cuentageprcim, String cuentaeprcim) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.idorigen = idorigen;
        this.cuentaaplica = cuentaaplica;
        this.cuentavencida = cuentavencida;
        this.cuentaintord = cuentaintord;
        this.cuentaidnc = cuentaidnc;
        this.cuentaidncv = cuentaidncv;
        this.cuentaidncres = cuentaidncres;
        this.cuentaoiod = cuentaoiod;
        this.cuentaintmor = cuentaintmor;
        this.cuentaiva = cuentaiva;
        this.cuentarc = cuentarc;
        this.cuentari = cuentari;
        this.tipoproducto = tipoproducto;
        this.tiporetiro = tiporetiro;
        this.tipocalculo = tipocalculo;
        this.tasaio = tasaio;
        this.tasaiod = tasaiod;
        this.tasaim = tasaim;
        this.iva = iva;
        this.ivaim = ivaim;
        this.garantias = garantias;
        this.avales = avales;
        this.reqsocio = reqsocio;
        this.tipoamortizacion = tipoamortizacion;
        this.maxeventos = maxeventos;
        this.maxdv = maxdv;
        this.saldominimo = saldominimo;
        this.saldomaximo = saldomaximo;
        this.cuentageprcc = cuentageprcc;
        this.cuentageprci = cuentageprci;
        this.cuentaeprcc = cuentaeprcc;
        this.cuentaeprci = cuentaeprci;
        this.cuentaoimd = cuentaoimd;
        this.cuentaoima = cuentaoima;
        this.cuentaoioa = cuentaoioa;
        this.cuentaivaim = cuentaivaim;
        this.cuentaivaidncvig = cuentaivaidncvig;
        this.cuentaivaidncven = cuentaivaidncven;
        this.cuentaivappidnc = cuentaivappidnc;
        this.cuentaintordv = cuentaintordv;
        this.plazomax = plazomax;
        this.tipofinalidad = tipofinalidad;
        this.activo = activo;
        this.pagodiafijo = pagodiafijo;
        this.cant_aperturas = cant_aperturas;
        this.producto_padre = producto_padre;
        this.tasasp = tasasp;
        this.ivasp = ivasp;
        this.cuentasp = cuentasp;
        this.cuentaivasp = cuentaivasp;
        this.tolerancia_im = tolerancia_im;
        this.tolerancia_com_no_pago = tolerancia_com_no_pago;
        this.monto_com_no_pago = monto_com_no_pago;
        this.comision_apertura = comision_apertura;
        this.rango_edad = rango_edad;
        this.evalua_aperturas = evalua_aperturas;
        this.cuentaintmorv = cuentaintmorv;
        this.cuentaidncmres = cuentaidncmres;
        this.cuentaidncm = cuentaidncm;
        this.cuentaidncmv = cuentaidncmv;
        this.cuentageprcim = cuentageprcim;
        this.cuentaeprcim = cuentaeprcim;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public String getCuentaaplica() {
        return cuentaaplica;
    }

    public void setCuentaaplica(String cuentaaplica) {
        this.cuentaaplica = cuentaaplica;
    }

    public String getCuentavencida() {
        return cuentavencida;
    }

    public void setCuentavencida(String cuentavencida) {
        this.cuentavencida = cuentavencida;
    }

    public String getCuentaintord() {
        return cuentaintord;
    }

    public void setCuentaintord(String cuentaintord) {
        this.cuentaintord = cuentaintord;
    }

    public String getCuentaidnc() {
        return cuentaidnc;
    }

    public void setCuentaidnc(String cuentaidnc) {
        this.cuentaidnc = cuentaidnc;
    }

    public String getCuentaidncv() {
        return cuentaidncv;
    }

    public void setCuentaidncv(String cuentaidncv) {
        this.cuentaidncv = cuentaidncv;
    }

    public String getCuentaidncres() {
        return cuentaidncres;
    }

    public void setCuentaidncres(String cuentaidncres) {
        this.cuentaidncres = cuentaidncres;
    }

    public String getCuentaoiod() {
        return cuentaoiod;
    }

    public void setCuentaoiod(String cuentaoiod) {
        this.cuentaoiod = cuentaoiod;
    }

    public String getCuentaintmor() {
        return cuentaintmor;
    }

    public void setCuentaintmor(String cuentaintmor) {
        this.cuentaintmor = cuentaintmor;
    }

    public String getCuentaiva() {
        return cuentaiva;
    }

    public void setCuentaiva(String cuentaiva) {
        this.cuentaiva = cuentaiva;
    }

    public String getCuentarc() {
        return cuentarc;
    }

    public void setCuentarc(String cuentarc) {
        this.cuentarc = cuentarc;
    }

    public String getCuentari() {
        return cuentari;
    }

    public void setCuentari(String cuentari) {
        this.cuentari = cuentari;
    }

    public Integer getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Integer tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public Integer getTiporetiro() {
        return tiporetiro;
    }

    public void setTiporetiro(Integer tiporetiro) {
        this.tiporetiro = tiporetiro;
    }

    public Integer getTipocalculo() {
        return tipocalculo;
    }

    public void setTipocalculo(Integer tipocalculo) {
        this.tipocalculo = tipocalculo;
    }

    public Integer getTasaio() {
        return tasaio;
    }

    public void setTasaio(Integer tasaio) {
        this.tasaio = tasaio;
    }

    public Integer getTasaiod() {
        return tasaiod;
    }

    public void setTasaiod(Integer tasaiod) {
        this.tasaiod = tasaiod;
    }

    public Integer getTasaim() {
        return tasaim;
    }

    public void setTasaim(Integer tasaim) {
        this.tasaim = tasaim;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getIvaim() {
        return ivaim;
    }

    public void setIvaim(Integer ivaim) {
        this.ivaim = ivaim;
    }

    public Integer getGarantias() {
        return garantias;
    }

    public void setGarantias(Integer garantias) {
        this.garantias = garantias;
    }

    public Integer getAvales() {
        return avales;
    }

    public void setAvales(Integer avales) {
        this.avales = avales;
    }

    public Boolean getReqsocio() {
        return reqsocio;
    }

    public void setReqsocio(Boolean reqsocio) {
        this.reqsocio = reqsocio;
    }

    public Integer getTipoamortizacion() {
        return tipoamortizacion;
    }

    public void setTipoamortizacion(Integer tipoamortizacion) {
        this.tipoamortizacion = tipoamortizacion;
    }

    public Integer getMaxeventos() {
        return maxeventos;
    }

    public void setMaxeventos(Integer maxeventos) {
        this.maxeventos = maxeventos;
    }

    public Integer getMaxdv() {
        return maxdv;
    }

    public void setMaxdv(Integer maxdv) {
        this.maxdv = maxdv;
    }

    public String getSaldominimo() {
        return saldominimo;
    }

    public void setSaldominimo(String saldominimo) {
        this.saldominimo = saldominimo;
    }

    public String getSaldomaximo() {
        return saldomaximo;
    }

    public void setSaldomaximo(String saldomaximo) {
        this.saldomaximo = saldomaximo;
    }

    public String getCuentageprcc() {
        return cuentageprcc;
    }

    public void setCuentageprcc(String cuentageprcc) {
        this.cuentageprcc = cuentageprcc;
    }

    public String getCuentageprci() {
        return cuentageprci;
    }

    public void setCuentageprci(String cuentageprci) {
        this.cuentageprci = cuentageprci;
    }

    public String getCuentaeprcc() {
        return cuentaeprcc;
    }

    public void setCuentaeprcc(String cuentaeprcc) {
        this.cuentaeprcc = cuentaeprcc;
    }

    public String getCuentaeprci() {
        return cuentaeprci;
    }

    public void setCuentaeprci(String cuentaeprci) {
        this.cuentaeprci = cuentaeprci;
    }

    public String getCuentaoimd() {
        return cuentaoimd;
    }

    public void setCuentaoimd(String cuentaoimd) {
        this.cuentaoimd = cuentaoimd;
    }

    public String getCuentaoima() {
        return cuentaoima;
    }

    public void setCuentaoima(String cuentaoima) {
        this.cuentaoima = cuentaoima;
    }

    public String getCuentaoioa() {
        return cuentaoioa;
    }

    public void setCuentaoioa(String cuentaoioa) {
        this.cuentaoioa = cuentaoioa;
    }

    public String getCuentaivaim() {
        return cuentaivaim;
    }

    public void setCuentaivaim(String cuentaivaim) {
        this.cuentaivaim = cuentaivaim;
    }

    public String getCuentaivaidncvig() {
        return cuentaivaidncvig;
    }

    public void setCuentaivaidncvig(String cuentaivaidncvig) {
        this.cuentaivaidncvig = cuentaivaidncvig;
    }

    public String getCuentaivaidncven() {
        return cuentaivaidncven;
    }

    public void setCuentaivaidncven(String cuentaivaidncven) {
        this.cuentaivaidncven = cuentaivaidncven;
    }

    public String getCuentaivappidnc() {
        return cuentaivappidnc;
    }

    public void setCuentaivappidnc(String cuentaivappidnc) {
        this.cuentaivappidnc = cuentaivappidnc;
    }

    public String getCuentaintordv() {
        return cuentaintordv;
    }

    public void setCuentaintordv(String cuentaintordv) {
        this.cuentaintordv = cuentaintordv;
    }

    public Integer getPlazomax() {
        return plazomax;
    }

    public void setPlazomax(Integer plazomax) {
        this.plazomax = plazomax;
    }

    public Integer getTipofinalidad() {
        return tipofinalidad;
    }

    public void setTipofinalidad(Integer tipofinalidad) {
        this.tipofinalidad = tipofinalidad;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getPagodiafijo() {
        return pagodiafijo;
    }

    public void setPagodiafijo(String pagodiafijo) {
        this.pagodiafijo = pagodiafijo;
    }

    public String getCant_aperturas() {
        return cant_aperturas;
    }

    public void setCant_aperturas(String cant_aperturas) {
        this.cant_aperturas = cant_aperturas;
    }

    public Integer getProducto_padre() {
        return producto_padre;
    }

    public void setProducto_padre(Integer producto_padre) {
        this.producto_padre = producto_padre;
    }

    public Integer getTasasp() {
        return tasasp;
    }

    public void setTasasp(Integer tasasp) {
        this.tasasp = tasasp;
    }

    public Integer getIvasp() {
        return ivasp;
    }

    public void setIvasp(Integer ivasp) {
        this.ivasp = ivasp;
    }

    public String getCuentasp() {
        return cuentasp;
    }

    public void setCuentasp(String cuentasp) {
        this.cuentasp = cuentasp;
    }

    public String getCuentaivasp() {
        return cuentaivasp;
    }

    public void setCuentaivasp(String cuentaivasp) {
        this.cuentaivasp = cuentaivasp;
    }

    public String getTolerancia_im() {
        return tolerancia_im;
    }

    public void setTolerancia_im(String tolerancia_im) {
        this.tolerancia_im = tolerancia_im;
    }

    public String getTolerancia_com_no_pago() {
        return tolerancia_com_no_pago;
    }

    public void setTolerancia_com_no_pago(String tolerancia_com_no_pago) {
        this.tolerancia_com_no_pago = tolerancia_com_no_pago;
    }

    public Double getMonto_com_no_pago() {
        return monto_com_no_pago;
    }

    public void setMonto_com_no_pago(Double monto_com_no_pago) {
        this.monto_com_no_pago = monto_com_no_pago;
    }

    public Double getComision_apertura() {
        return comision_apertura;
    }

    public void setComision_apertura(Double comision_apertura) {
        this.comision_apertura = comision_apertura;
    }

    public String getRango_edad() {
        return rango_edad;
    }

    public void setRango_edad(String rango_edad) {
        this.rango_edad = rango_edad;
    }

    public String getEvalua_aperturas() {
        return evalua_aperturas;
    }

    public void setEvalua_aperturas(String evalua_aperturas) {
        this.evalua_aperturas = evalua_aperturas;
    }

    public String getCuentaintmorv() {
        return cuentaintmorv;
    }

    public void setCuentaintmorv(String cuentaintmorv) {
        this.cuentaintmorv = cuentaintmorv;
    }

    public String getCuentaidncmres() {
        return cuentaidncmres;
    }

    public void setCuentaidncmres(String cuentaidncmres) {
        this.cuentaidncmres = cuentaidncmres;
    }

    public String getCuentaidncm() {
        return cuentaidncm;
    }

    public void setCuentaidncm(String cuentaidncm) {
        this.cuentaidncm = cuentaidncm;
    }

    public String getCuentaidncmv() {
        return cuentaidncmv;
    }

    public void setCuentaidncmv(String cuentaidncmv) {
        this.cuentaidncmv = cuentaidncmv;
    }

    public String getCuentageprcim() {
        return cuentageprcim;
    }

    public void setCuentageprcim(String cuentageprcim) {
        this.cuentageprcim = cuentageprcim;
    }

    public String getCuentaeprcim() {
        return cuentaeprcim;
    }

    public void setCuentaeprcim(String cuentaeprcim) {
        this.cuentaeprcim = cuentaeprcim;
    }

    @Override
    public String toString() {
        return "Productos{" + "idproducto=" + idproducto + ", nombre=" + nombre + ", idorigen=" + idorigen + ", cuentaaplica=" + cuentaaplica + ", cuentavencida=" + cuentavencida + ", cuentaintord=" + cuentaintord + ", cuentaidnc=" + cuentaidnc + ", cuentaidncv=" + cuentaidncv + ", cuentaidncres=" + cuentaidncres + ", cuentaoiod=" + cuentaoiod + ", cuentaintmor=" + cuentaintmor + ", cuentaiva=" + cuentaiva + ", cuentarc=" + cuentarc + ", cuentari=" + cuentari + ", tipoproducto=" + tipoproducto + ", tiporetiro=" + tiporetiro + ", tipocalculo=" + tipocalculo + ", tasaio=" + tasaio + ", tasaiod=" + tasaiod + ", tasaim=" + tasaim + ", iva=" + iva + ", ivaim=" + ivaim + ", garantias=" + garantias + ", avales=" + avales + ", reqsocio=" + reqsocio + ", tipoamortizacion=" + tipoamortizacion + ", maxeventos=" + maxeventos + ", maxdv=" + maxdv + ", saldominimo=" + saldominimo + ", saldomaximo=" + saldomaximo + ", cuentageprcc=" + cuentageprcc + ", cuentageprci=" + cuentageprci + ", cuentaeprcc=" + cuentaeprcc + ", cuentaeprci=" + cuentaeprci + ", cuentaoimd=" + cuentaoimd + ", cuentaoima=" + cuentaoima + ", cuentaoioa=" + cuentaoioa + ", cuentaivaim=" + cuentaivaim + ", cuentaivaidncvig=" + cuentaivaidncvig + ", cuentaivaidncven=" + cuentaivaidncven + ", cuentaivappidnc=" + cuentaivappidnc + ", cuentaintordv=" + cuentaintordv + ", plazomax=" + plazomax + ", tipofinalidad=" + tipofinalidad + ", activo=" + activo + ", pagodiafijo=" + pagodiafijo + ", cant_aperturas=" + cant_aperturas + ", producto_padre=" + producto_padre + ", tasasp=" + tasasp + ", ivasp=" + ivasp + ", cuentasp=" + cuentasp + ", cuentaivasp=" + cuentaivasp + ", tolerancia_im=" + tolerancia_im + ", tolerancia_com_no_pago=" + tolerancia_com_no_pago + ", monto_com_no_pago=" + monto_com_no_pago + ", comision_apertura=" + comision_apertura + ", rango_edad=" + rango_edad + ", evalua_aperturas=" + evalua_aperturas + ", cuentaintmorv=" + cuentaintmorv + ", cuentaidncmres=" + cuentaidncmres + ", cuentaidncm=" + cuentaidncm + ", cuentaidncmv=" + cuentaidncmv + ", cuentageprcim=" + cuentageprcim + ", cuentaeprcim=" + cuentaeprcim + '}';
    }

        


	
	
	
	
	
	
}
