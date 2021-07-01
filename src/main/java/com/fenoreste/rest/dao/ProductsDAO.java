package com.fenoreste.rest.dao;

import com.fenoreste.rest.entidades.Productos;

public class ProductsDAO extends FacadeProductos<Productos> {

    public ProductsDAO() {
        super(Productos.class);
    }
}
