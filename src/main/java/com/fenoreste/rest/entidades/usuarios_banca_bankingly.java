/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "usuarios_bancam_bankingly")
public class usuarios_banca_bankingly implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_usuarios_bankingly")
    @SequenceGenerator(name = "sec_usuarios_bankingly", sequenceName = "sec_usuarios_bankingly")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "socio")
    private String socio;

    public usuarios_banca_bankingly() {
    }

    public usuarios_banca_bankingly(int id, String username, String socio) {
        this.id = id;
        this.username = username;
        this.socio = socio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "usuarios_banca_bankingly{" + "id=" + id + ", username=" + username + ", socio=" + socio + '}';
    }

}
