/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class personaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customerId;
    private String name;
    private String addres;
    private int age;
    private String gender;
    private String phone;
    private String mail;
    private boolean status;
    
    public personaDTO() {
    }

    public personaDTO(String customerId, String name, String addres, int age, String gender, String phone, String mail, boolean status) {
        this.customerId = customerId;
        this.name = name;
        this.addres = addres;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "personaDTO{" + "customerId=" + customerId + ", name=" + name + ", addres=" + addres + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", mail=" + mail + ", status=" + status + '}';
    }
    
    
}
