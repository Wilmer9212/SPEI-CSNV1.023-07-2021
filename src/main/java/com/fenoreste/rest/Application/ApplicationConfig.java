/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.Application;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author wilmer
 */
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class);
        resources.add(com.fenoreste.rest.Application.GenericResource.class);
        resources.add(com.fenoreste.rest.services.AccountsResources.class);
        resources.add(com.fenoreste.rest.services.CustomerResources.class);
        resources.add(com.fenoreste.rest.services.LoanResources.class);
        resources.add(com.fenoreste.rest.services.ProductsResources.class);
        resources.add(com.fenoreste.rest.services.TercerosResources.class);
        resources.add(com.fenoreste.rest.services.TestResources.class);
        resources.add(com.fenoreste.rest.services.TransactionResources.class);
    }
    
}
