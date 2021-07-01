package com.fenoreste.rest.dao;

import com.fenoreste.rest.entidades.Persona;

public class CustomerDAO extends FacadeCustomer<Persona> {

	 public CustomerDAO() {
	     super(Persona.class);
  }     
}
