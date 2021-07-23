/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author wilmer
 */
@Cacheable(false)
@Entity
public class SaiComisionCobranza implements Serializable {

    @Id
    @Column(name = "tasaComision")
    private double tasaComision;
    @Column(name = "montoComision")
    private double montoComision;
    @Column(name = "montoFijo")
    private double montoFijo;
    @Column(name = "tasaProporcional")
    private double tasaProporcional;
    @Column(name = "proporcional")
    private double proporcional;
    @Column(name = "esMontoModificado")
    private Boolean esMontoModificado;

    public SaiComisionCobranza() {
    }

    public double getTasaComision() {
        return tasaComision;
    }

    public void setTasaComision(double tasaComision) {
        this.tasaComision = tasaComision;
    }

    public double getMontoComision() {
        return montoComision;
    }

    public void setMontoComision(double montoComision) {
        this.montoComision = montoComision;
    }

    public double getMontoFijo() {
        return montoFijo;
    }

    public void setMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    public double getTasaProporcional() {
        return tasaProporcional;
    }

    public void setTasaProporcional(double tasaProporcional) {
        this.tasaProporcional = tasaProporcional;
    }

    public double getProporcional() {
        return proporcional;
    }

    public void setProporcional(double proporcional) {
        this.proporcional = proporcional;
    }

    public Boolean getEsMontoModificado() {
        return esMontoModificado;
    }

    public void setEsMontoModificado(Boolean esMontoModificado) {
        this.esMontoModificado = esMontoModificado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.tasaComision) ^ (Double.doubleToLongBits(this.tasaComision) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.montoComision) ^ (Double.doubleToLongBits(this.montoComision) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.montoFijo) ^ (Double.doubleToLongBits(this.montoFijo) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.tasaProporcional) ^ (Double.doubleToLongBits(this.tasaProporcional) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.proporcional) ^ (Double.doubleToLongBits(this.proporcional) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.esMontoModificado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SaiComisionCobranza other = (SaiComisionCobranza) obj;
        if (Double.doubleToLongBits(this.tasaComision) != Double.doubleToLongBits(other.tasaComision)) {
            return false;
        }
        if (Double.doubleToLongBits(this.montoComision) != Double.doubleToLongBits(other.montoComision)) {
            return false;
        }
        if (Double.doubleToLongBits(this.montoFijo) != Double.doubleToLongBits(other.montoFijo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tasaProporcional) != Double.doubleToLongBits(other.tasaProporcional)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proporcional) != Double.doubleToLongBits(other.proporcional)) {
            return false;
        }
        return Objects.equals(this.esMontoModificado, other.esMontoModificado);
    }

    @Override
    public String toString() {
        return "SaiComisionCobranza{" + "tasaComision=" + tasaComision + ", montoComision=" + montoComision + ", montoFijo=" + montoFijo + ", tasaProporcional=" + tasaProporcional + ", proporcional=" + proporcional + ", esMontoModificado=" + esMontoModificado + '}';
    }

}
