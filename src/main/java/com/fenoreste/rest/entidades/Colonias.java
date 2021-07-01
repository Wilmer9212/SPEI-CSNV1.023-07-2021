package com.fenoreste.rest.entidades;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Cacheable(false)
@Entity
@Table(name = "colonias")
public class Colonias implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolonia")
    private Integer idcolonia;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "idmunicipio")
    private Integer idmunicipio;
    @Column(name = "codigopostal")
    private String codigopostal;

    public Colonias() {
    }

    public Colonias(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public Colonias(Integer idcolonia, String nombre) {
        this.idcolonia = idcolonia;
        this.nombre = nombre;
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcolonia != null ? idcolonia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colonias)) {
            return false;
        }
        Colonias other = (Colonias) object;
        return !((this.idcolonia == null && other.idcolonia != null) || (this.idcolonia != null && !this.idcolonia.equals(other.idcolonia)));
    }

    @Override
    public String toString() {
        return "Colonias{" + "idcolonia=" + idcolonia + ", nombre=" + nombre + ", idmunicipio=" + idmunicipio + ", codigopostal=" + codigopostal + '}';
    }

   

}


