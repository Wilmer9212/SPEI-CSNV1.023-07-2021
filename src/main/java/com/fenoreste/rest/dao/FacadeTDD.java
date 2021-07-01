/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.dao;

import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.Util.AbstractFacade_1;
import com.fenoreste.rest.entidades.Tablas;
import com.fenoreste.rest.entidades.TablasPK;
import com.syc.services.SiscoopTDD;
import com.syc.ws.endpoint.siscoop.BalanceQueryResponseDto;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.namespace.QName;

/**
 *
 * @author Elliot
 */


//MetodosImplementadosDeSyC
public abstract class FacadeTDD<T> {

    Calendar calendar = Calendar.getInstance();
    Date hoy = calendar.getTime();
    public static EntityManagerFactory emf;

    public FacadeTDD(Class<T> entityClass) {
        emf = AbstractFacade.conexion();       
       
    }
   
    
   public BalanceQueryResponseDto balanceQuery(String pan){        
        EntityManager em=emf.createEntityManager();
        double saldo;
        try {
            TablasPK pk=new TablasPK("siscoop_banca_movil","wsdl_parametros");
            Tablas tb=em.find(Tablas.class, pk);             
            if(authSyC(tb.getDato1(),tb.getDato2())){
                SiscoopTDD tdd=new SiscoopTDD(tb.getDato1(),tb.getDato2());
                BalanceQueryResponseDto dto=tdd.getSiscoop().getBalanceQuery(pan);
                return dto;
            }
        } catch (Exception e) {
            em.clear();
            em.close();
            System.out.println("Error al consultar saldo de TDD:"+e.getMessage());
        }
        em.clear();
        em.close();
        return null;
    }
  
    public boolean authSyC(String user,String pass){
        System.out.println("llego a auth");
        System.out.println("user:"+user+",pass:"+pass);
        boolean bandera=true;
        try {                       
            System.out.println("entro a try");
            SiscoopTDD syc=new SiscoopTDD(user,pass);
            System.out.println("salio");
            bandera=true;
        } catch (Exception e) {            
            System.out.println("Error al autenticar:"+e.getMessage());
        }
        System.out.println("fin");
        return bandera;
    }
    
       public void cerrar() {
        emf.close();
    }
       
         // REALIZA UN PING A LA URL DEL WSDL
    private boolean pingURL(URL url, String tiempo) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(Integer.parseInt(tiempo));
            connection.setReadTimeout(Integer.parseInt(tiempo));
            int codigo = connection.getResponseCode();

            if (codigo == 200) {
                return true;
            }
        } catch (IOException ex) {
            System.out.println("Error al conectarse a SYC: " + ex.getMessage());
        }
        return false;
    }
    
    public boolean pingging() throws MalformedURLException{
          boolean bandera=false;
          
          EntityManager em=emf.createEntityManager();
          TablasPK tablasPK = new TablasPK("siscoop_banca_movil", "wsdl");
          Tablas tb=em.find(Tablas.class, tablasPK);
          String wsdlLocation = "http://" + tb.getDato1() + ":" + tb.getDato3() + "/syc/webservice/" + tb.getDato2() + "?wsdl";
            //"http://200.15.1.143:8080/syc/webservice/siscoopAlternativeService/?wsld"
            QName QNAME = new QName("http://impl.siscoop.endpoint.ws.syc.com/", "SiscoopAlternativeEndpointImplService");
            URL url = new URL(wsdlLocation);
            if (pingURL(url, tb.getDato4())) {
                bandera=true;
             }else{
                bandera=false;;;;
            }
            em.clear();
            em.close();
            return bandera;
    }
    
    
}