/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elliot
 */
@Cacheable(false)
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PersonasPK personasPK;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numeroext")
    private String numeroext;
    @Column(name = "numeroint")
    private String numeroint;
    @Column(name = "entrecalles")
    private String entrecalles;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "lugarnacimiento")
    private String lugarnacimiento;
    @Column(name = "efnacimiento")
    private Integer efnacimiento;
    @Column(name = "sexo")
    private Short sexo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "telefonorecados")
    private String telefonorecados;
    @Column(name = "listanegra")
    private Boolean listanegra;
    @Column(name = "estadocivil")
    private Short estadocivil;
    @Column(name = "idcoop")
    private String idcoop;
    @Column(name = "idsector")
    private Integer idsector;
    @Column(name = "estatus")
    private Boolean estatus;
    @Column(name = "aceptado")
    private Boolean aceptado;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Column(name = "fecharetiro")
    @Temporal(TemporalType.DATE)
    private Date fecharetiro;
    @Column(name = "fechaciudad")
    @Temporal(TemporalType.DATE)
    private Date fechaciudad;
    @Column(name = "regimen_mat")
    private Short regimenMat;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "medio_inf")
    private Short medioInf;
    @Column(name = "requisitos")
    private Integer requisitos;
    @Column(name = "appaterno")
    private String appaterno;
    @Column(name = "apmaterno")
    private String apmaterno;
    @Column(name = "nacionalidad")
    private Short nacionalidad;
    @Column(name = "grado_estudios")
    private Short gradoEstudios;
    @Column(name = "categoria")
    private Short categoria;
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "curp")
    private String curp;
    @Column(name = "email")
    private String email;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "causa_baja")
    private Integer causaBaja;
    @Column(name = "nivel_riesgo")
    private Short nivelRiesgo;
    @Column(name = "celular")
    private String celular;
    @Column(name = "rfc_valido")
    private Boolean rfcValido;
    @Column(name = "curp_valido")
    private Boolean curpValido;
    @Column(name = "idcolonia")
    private Integer idcolonia;

    public Persona() {
    }

    public Persona(PersonasPK personasPK) {
        this.personasPK = personasPK;
    }

    public Persona(int idorigen, int idgrupo, int idsocio) {
        this.personasPK = new PersonasPK(idorigen, idgrupo, idsocio);
    }

    public PersonasPK getPersonasPK() {
        return personasPK;
    }

    public void setPersonasPK(PersonasPK personasPK) {
        this.personasPK = personasPK;
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

    public String getEntrecalles() {
        return entrecalles;
    }

    public void setEntrecalles(String entrecalles) {
        this.entrecalles = entrecalles;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public Integer getEfnacimiento() {
        return efnacimiento;
    }

    public void setEfnacimiento(Integer efnacimiento) {
        this.efnacimiento = efnacimiento;
    }

    public Short getSexo() {
        return sexo;
    }

    public void setSexo(Short sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonorecados() {
        return telefonorecados;
    }

    public void setTelefonorecados(String telefonorecados) {
        this.telefonorecados = telefonorecados;
    }

    public Boolean getListanegra() {
        return listanegra;
    }

    public void setListanegra(Boolean listanegra) {
        this.listanegra = listanegra;
    }

    public Short getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(Short estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getIdcoop() {
        return idcoop;
    }

    public void setIdcoop(String idcoop) {
        this.idcoop = idcoop;
    }

    public Integer getIdsector() {
        return idsector;
    }

    public void setIdsector(Integer idsector) {
        this.idsector = idsector;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFecharetiro() {
        return fecharetiro;
    }

    public void setFecharetiro(Date fecharetiro) {
        this.fecharetiro = fecharetiro;
    }

    public Date getFechaciudad() {
        return fechaciudad;
    }

    public void setFechaciudad(Date fechaciudad) {
        this.fechaciudad = fechaciudad;
    }

    public Short getRegimenMat() {
        return regimenMat;
    }

    public void setRegimenMat(Short regimenMat) {
        this.regimenMat = regimenMat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getMedioInf() {
        return medioInf;
    }

    public void setMedioInf(Short medioInf) {
        this.medioInf = medioInf;
    }

    public Integer getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Integer requisitos) {
        this.requisitos = requisitos;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public Short getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Short nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Short getGradoEstudios() {
        return gradoEstudios;
    }

    public void setGradoEstudios(Short gradoEstudios) {
        this.gradoEstudios = gradoEstudios;
    }

    public Short getCategoria() {
        return categoria;
    }

    public void setCategoria(Short categoria) {
        this.categoria = categoria;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getCausaBaja() {
        return causaBaja;
    }

    public void setCausaBaja(Integer causaBaja) {
        this.causaBaja = causaBaja;
    }

    public Short getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(Short nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getRfcValido() {
        return rfcValido;
    }

    public void setRfcValido(Boolean rfcValido) {
        this.rfcValido = rfcValido;
    }

    public Boolean getCurpValido() {
        return curpValido;
    }

    public void setCurpValido(Boolean curpValido) {
        this.curpValido = curpValido;
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.personasPK);
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.personasPK, other.personasPK);
    }

    @Override
    public String toString() {
        return "Personas{" + "personasPK=" + personasPK + ", calle=" + calle + ", numeroext=" + numeroext + ", numeroint=" + numeroint + ", entrecalles=" + entrecalles + ", fechanacimiento=" + fechanacimiento + ", lugarnacimiento=" + lugarnacimiento + ", efnacimiento=" + efnacimiento + ", sexo=" + sexo + ", telefono=" + telefono + ", telefonorecados=" + telefonorecados + ", listanegra=" + listanegra + ", estadocivil=" + estadocivil + ", idcoop=" + idcoop + ", idsector=" + idsector + ", estatus=" + estatus + ", aceptado=" + aceptado + ", fechaingreso=" + fechaingreso + ", fecharetiro=" + fecharetiro + ", fechaciudad=" + fechaciudad + ", regimenMat=" + regimenMat + ", nombre=" + nombre + ", medioInf=" + medioInf + ", requisitos=" + requisitos + ", appaterno=" + appaterno + ", apmaterno=" + apmaterno + ", nacionalidad=" + nacionalidad + ", gradoEstudios=" + gradoEstudios + ", categoria=" + categoria + ", rfc=" + rfc + ", curp=" + curp + ", email=" + email + ", razonSocial=" + razonSocial + ", causaBaja=" + causaBaja + ", nivelRiesgo=" + nivelRiesgo + ", celular=" + celular + ", rfcValido=" + rfcValido + ", curpValido=" + curpValido + ", idcolonia=" + idcolonia + '}';
    }

}
