/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

/**
 *
 * @author wilmer
 */
public class usuarios_banca_bankinglyDTO {
    
    
    private int id;
    private String username;
    private String socio;

    public usuarios_banca_bankinglyDTO() {
    }

    public usuarios_banca_bankinglyDTO(int id, String username, String socio) {
        this.id = id;
        this.username = username;
        this.socio = socio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
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
