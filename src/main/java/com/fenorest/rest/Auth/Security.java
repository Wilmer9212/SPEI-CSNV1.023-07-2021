/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenorest.rest.Auth;

import com.fenoreste.rest.Util.AbstractFacade;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Elliot
 */
public class Security {  
  public boolean isUserAuthenticated(String authString){
         System.out.println("Aut:"+authString);
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        if(authString==null){
            return false;
        }else{
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        decodedAuth = new String(bytes);
        String[]cadena =decodedAuth.split(":");
        String user=cadena[0]; 
        String pass=cadena[1];
        
               
        
        if(getUser(user, pass)){
            return true;
        }
        System.out.println("User:"+user);
        
        }
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return false;
    }
  
    private boolean getUser(String username,String password){
        boolean bandera=false;
        
        EntityManagerFactory emf=AbstractFacade.conexion();
        try {            
        EntityManager em=emf.createEntityManager();
        String consulta="SELECT status FROM user_rest WHERE username='"+username+"' AND password='"+password+"'";
        Query query=em.createNativeQuery(consulta);
        boolean st=(boolean) query.getSingleResult();
        if(st){
            bandera=true;
        }
        } catch (Exception e) {
            System.out.println("Error en status");
        }
        emf.close();
        return bandera;
        
    }
}
