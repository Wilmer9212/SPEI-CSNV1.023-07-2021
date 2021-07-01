package com.fenoreste.rest.dao;

import com.fenoreste.rest.ResponseDTO.personaDTO;
import com.fenoreste.rest.ResponseDTO.accountsDTO;
import com.fenoreste.rest.ResponseDTO.ClientByDocumentDTO;
import com.fenoreste.rest.ResponseDTO.usuarios_banca_bankinglyDTO;
import com.fenoreste.rest.ResponseDTO.customerDTO;
import com.fenoreste.rest.entidades.Colonias;
import com.fenoreste.rest.entidades.Grupos;
import com.fenoreste.rest.entidades.Persona;
import com.fenoreste.rest.entidades.PersonasPK;
import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.entidades.usuarios_banca_bankingly;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

public abstract class FacadeCustomer<T> {

    private static EntityManagerFactory emf;

    List<Object[]> lista = null;

    public FacadeCustomer(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }

    public ClientByDocumentDTO getClientByDocument(String documentId, int clientType, String Name, String LastName, String Mail, String Phone, String CellPhone, String UserName) {
        EntityManager em = emf.createEntityManager();
        ClientByDocumentDTO client = null;
        List<ClientByDocumentDTO> clientes = new ArrayList<ClientByDocumentDTO>();
        usuarios_banca_bankinglyDTO users = null;
        System.out.println("LastName:" + LastName);
        String IdentClientType = "";
        if (clientType == 1) {
            IdentClientType = "curp";
        } else if (clientType == 2) {
            IdentClientType = "rfc";
        }

        try {
            String consulta = "SELECT replace(to_char(p.idorigen,'099999')||to_char(p.idgrupo,'09')||to_char(p.idsocio,'099999'),' ','') as ogs,"
                    + "nombre||' '||appaterno||' '||apmaterno as nombrec,"
                    + "p.idgrupo as grupo,"
                    + "p.idorigen||''||p.idgrupo||''||p.idsocio as identificador "
                    + "FROM personas p WHERE "
                    + "replace((p." + IdentClientType.toUpperCase() + "),' ','')='" + documentId.replace(" ","") + "'"
                    + " AND replace(UPPER(p.nombre),' ','')='" + Name.toUpperCase().replace(" ","") + "'"
                    + " AND UPPER(replace(p.appaterno,' ','')||''||replace(p.apmaterno,' ','')) like '%" + LastName.toUpperCase().replace(" ", "") + "%'"
                    + " AND UPPER(replace(p.email,' ',''))='" + Mail.toUpperCase().replace(" ","") + "'"
                    + " AND replace(p.telefono,' ','')='" + Phone.replace(" ","") + "'"
                    + " AND replace(p.celular,' ','')='" + CellPhone.replace(" ","") + "'";
            System.out.println("Consulta:" + consulta);

            Query query = em.createNativeQuery(consulta);
            List<Object[]> SocioEncontrados = query.getResultList();
            System.out.println("salio:" + SocioEncontrados.size());
            for (Object[] objetos : SocioEncontrados) {
                Grupos grupo = em.find(Grupos.class, Integer.parseInt(objetos[2].toString()));
                client = new ClientByDocumentDTO(objetos[0].toString(), objetos[1].toString(), String.valueOf(clientType), documentId + "" + String.valueOf(clientType));
            /*usuarios_banca_bankingly userDB = new usuarios_banca_bankingly(0, UserName, users.getSocio());
            
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            em.persist(userDB);
            tr.commit();*/
            }
            System.out.println("Username:" + UserName);

            return client;

        } catch (Exception e) {
            System.out.println("Error al procesar GetClientByDocument:" + e.getMessage());
            cerrar();
        }
        return null;
    }

    //Metodo para saber si la personas realmente existe en la base de datos
    public boolean SearchPersonas(int clientType,String documentId,String Name, String LastName, String Mail, String Phone, String CellPhone) throws Throwable {
        EntityManager em = emf.createEntityManager();
        List<Persona> Lista = null;
        boolean bandera = false;
        String IdentClientType="";
        if(clientType==1){
            IdentClientType="curp";
        }else if(clientType==2){
            IdentClientType="rfc";
        }
        
        
        try {
            String consulta = "SELECT * FROM personas p WHERE "
                    + "replace((p." + IdentClientType.toUpperCase() + "),' ','')='" + documentId.replace(" ","").trim() + "' AND "
                    + " replace(UPPER(p.nombre),' ','')='" + Name.toUpperCase().replace(" ","").trim() + "' AND "
                    + "UPPER(replace(p.appaterno,' ','')||''||replace(p.apmaterno,' ','')) like '%" + LastName.toUpperCase().replace(" ", "") + "%' AND "
                    + "replace(UPPER(p.email),' ','') like'%" + Mail.toUpperCase().trim() + "%' AND "
                    + "replace(p.telefono,' ','')='" + Phone.replace(" ","").trim() + "' AND "
                    + "replace(p.celular,' ','')='" + CellPhone.replace(" ","").trim() + "'";
            System.out.println("Consulta:" + consulta);

            Query query = em.createNativeQuery(consulta, Persona.class);
            Lista = query.getResultList();
            if (Lista.size() > 0) {
                bandera = true;
            } else {
                bandera = false;
            }

        } catch (Exception e) {
            System.out.println("Error al Buscar personas:" + e.getMessage());
        } finally {
            System.out.println("en finally");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
            }
            em.close();
        }
        return bandera;
    }

    public boolean findUser(String user) {
        boolean bandera = false;

        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createNativeQuery("SELECT count(*) FROM usuarios_bancam_bankingly WHERE username='" + user + "'");
            int count = Integer.parseInt(query.getSingleResult().toString());
            if (count > 0) {
                bandera = true;
            } else {
                bandera = false;
            }
        } catch (Exception e) {
            System.out.println("Error en metodo para buscar usuario:" + e.getMessage());
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
            }
            em.close();

        }
        return bandera;
    }
    
    
    public String findOGS(String user) {
        boolean bandera = false;
        EntityManager em = emf.createEntityManager();
        try {
            String consulta="SELECT socio FROM usuarios_bancam_bankingly WHERE username='" + user + "'";
            Query query = em.createNativeQuery(consulta);
            System.out.println("consulta:"+consulta);
            String ogs =query.getSingleResult().toString();
            if (!ogs.equals("")) {
             return ogs;                          
            }
        } catch (Exception e) {
            System.out.println("Error en metodo para buscar usuario:" + e.getMessage());
        } finally {
            em.close();

        }
        return null;
    }
    
    

    //Metodo para buscar todos los socios por nombre o por id
    public List<customerDTO> search(String nombre, String customerId) {
        System.out.println("name:" + nombre + ", customerId:" + customerId);
        String complemento = "";
        List<customerDTO> ListaPersonas = new ArrayList<customerDTO>();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (!nombre.equals("")) {
            String consulta = "SELECT replace(to_char(p.idorigen,'099999')||to_char(p.idgrupo,'09')||to_char(p.idsocio,'099999'),' ','') as ogs,nombre||' '||appaterno||' '||apmaterno as nombrec,"
                    + "(case  when p.idgrupo=1  then 'Socio Contable'"
                    + "when p.idgrupo=60 then 'Aval no socio'"
                    + "when p.idgrupo=61 then 'Conyuge no socio'"
                    + "when p.idgrupo=62 then 'Tutor no socio'"
                    + "when p.idgrupo=63 then 'Beneficiario no socio'"
                    + "when p.idgrupo=64 then 'Referencia personal no socio'"
                    + "when p.idgrupo=8  then 'Prospecto a socio'"
                    + "when p.idgrupo=9  then 'Aspirante'"
                    + "when p.idgrupo=10 then 'Socio'"
                    + "when p.idgrupo=40 then 'Socio castigado'"
                    + "when p.idgrupo=41 then 'Socio dado de baja'"
                    + "when p.idgrupo=42 then 'Aspirante dado de baja'"
                    + "when p.idgrupo=43 then 'Prospecto dado de baja'"
                    + "when p.idgrupo=44 then 'Menor dado de baja'"
                    + "when p.idgrupo=45 then 'Ex-socio'"
                    + "when p.idgrupo=46 then 'Ex-aspirante'"
                    + "when p.idgrupo=47 then 'Ex-ahorrador menor'"
                    + "when p.idgrupo=20 then 'Ahorrador menor'"
                    + "when p.idgrupo=81 then 'Empleados'"
                    + "when p.idgrupo=48 then 'Recursos no socio'"
                    + "when p.idgrupo=88 then 'Personas bloqueadas cnbv'"
                    + "when p.idgrupo=66 then 'Proveedores personas fisicas'"
                    + "when p.idgrupo=67 then 'Proveedores personas morales'"
                    + "when p.idgrupo=49 then 'Propietario real no socios'"
                    + "when p.idgrupo=65 then 'Usuarios remesas' else 'Sin nombre para el grupo' end) as tps from personas p WHERE nombre||' '||appaterno||' '||apmaterno LIKE '%" + nombre.toUpperCase() + "%'";
            try {
                Query query = em.createNativeQuery(consulta);
                lista = query.getResultList();
                Object[] ok = null;
                for (int i = 0; i < lista.size(); i++) {
                    ok = lista.get(i);
                    customerDTO persona = new customerDTO(ok[0].toString(), ok[1].toString(), ok[2].toString());
                    ListaPersonas.add(persona);
                }
            } catch (Exception e) {
                System.out.println("Error al buscar cliente:" + e.getMessage());
            }

        } else if (!customerId.equals("")) {
            int o = Integer.parseInt(customerId.substring(0, 6));
            int g = Integer.parseInt(customerId.substring(6, 8));
            int s = Integer.parseInt(customerId.substring(8, 14));
            PersonasPK pk = new PersonasPK(o, g, s);
            Persona personas = em.find(Persona.class, pk);
            int grupo = personas.getPersonasPK().getIdgrupo();
            System.out.println("IdGrupo:" + grupo);
            String customerType = "";

            if (grupo == 1) {
                customerType = "Socio contable";
            } else if (grupo == 60) {
                customerType = "Aval no socio";
            } else if (grupo == 61) {
                customerType = "Conyuge no socio";
            } else if (grupo == 62) {
                customerType = "Aval no socio";
            } else if (grupo == 63) {
                customerType = "Beneficiario no socio";
            } else if (grupo == 64) {
                customerType = "Referencia personal no socio";
            } else if (grupo == 8) {
                customerType = "Prospecto a socio";
            } else if (grupo == 9) {
                customerType = "Aspirante";
            } else if (grupo == 10) {
                customerType = "Socio";
            } else if (grupo == 40) {
                customerType = "Socio castigado";
            } else if (grupo == 41) {
                customerType = "Socio dado de baja";
            } else if (grupo == 42) {
                customerType = "Aspirante dado de baja";
            } else if (grupo == 43) {
                customerType = "Prospecto dado de baja";
            } else if (grupo == 44) {
                customerType = "Menor dado de baja";
            } else if (grupo == 45) {
                customerType = "Ex-socio";
            } else if (grupo == 46) {
                customerType = "Ex-aspirante";
            } else if (grupo == 47) {
                customerType = "Ex-ahorrador menor";
            } else if (grupo == 20) {
                customerType = "Ahorrador menor";
            } else if (grupo == 81) {
                customerType = "Empleados";
            } else if (grupo == 48) {
                customerType = "Recursos no socio";
            } else if (grupo == 88) {
                customerType = "Personas bloqueadas cnbv";
            } else if (grupo == 66) {
                customerType = "Proveedores personas fisicas";
            } else if (grupo == 67) {
                customerType = "Proveedores personas morales";
            } else if (grupo == 49) {
                customerType = "Propietario real no socios";
            } else if (grupo == 65) {
                customerType = "Usuarios remesas";
            } else {
                customerType = "Sin nombre para el grupo";
            }
            customerDTO persona = new customerDTO(customerId, personas.getNombre() + " " + personas.getAppaterno() + " " + personas.getApmaterno(), customerType);
            ListaPersonas.add(persona);
            //complemento = "replace(to_char(p.idorigen,'099999')||to_char(p.idgrupo,'09')||to_char(p.idsocio,'099999'),' ','')= '" + customerId + "'";
        }

        em.clear();
        em.close();
        return ListaPersonas;
    }

    public List<personaDTO> details(String customerId) {
        EntityManager em = emf.createEntityManager();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<personaDTO> ListaPersonas = new ArrayList<personaDTO>();
        int o = Integer.parseInt(customerId.substring(0, 6));
        int g = Integer.parseInt(customerId.substring(6, 8));
        int s = Integer.parseInt(customerId.substring(8, 14));
        try {
            PersonasPK personapk = new PersonasPK(o, g, s);
            Persona persona = em.find(Persona.class, personapk);
            Colonias col = em.find(Colonias.class, persona.getIdcolonia());
            String sexo = "";
            String estatus = "";
            if (persona.getSexo() == 1) {
                sexo = "Masculino";
            } else if (persona.getSexo() == 2) {
                sexo = "Femenino";
            }

            if (persona.getEstatus() == true) {
                estatus = "Activo";
            } else {
                estatus = "Inactivo";
            }
            String nombre = persona.getNombre() + " " + persona.getApmaterno() + " " + persona.getAppaterno();
            String domicilio = col.getNombre() + " " + persona.getNumeroint() + " " + persona.getNumeroext();

            System.out.println("Telefono:" + persona.getTelefono());
            String telefono = persona.getTelefono().trim();
            String email = persona.getEmail();
            Date dates = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            int fechaNa = Integer.parseInt(persona.getFechanacimiento().toString().substring(0, 4));
            int edad = year - fechaNa;
            System.out.println("paso");
            personaDTO personaDTO = new personaDTO(
                    customerId,
                    nombre,
                    domicilio,
                    edad,
                    sexo,
                    telefono,
                    email,
                    persona.getEstatus());
            ListaPersonas.add(personaDTO);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        em.close();
        System.out.println("Lista:" + ListaPersonas);
        return ListaPersonas;
    }

    public List<accountsDTO> getAccounts(String customerId) {
        EntityManager em = emf.createEntityManager();
        Query query = null;
        List<accountsDTO> listaCuentas = new ArrayList<accountsDTO>();
        String consulta = "SELECT replace(to_char(a.idorigenp,'099999')||to_char(a.idproducto,'0009')||to_char(a.idauxiliar,'099999'),' ','') as accountId,"
                + "(SELECT nombre FROM productos WHERE idproducto=a.idproducto) as accountType,"
                + "a.saldo as balance,"
                + "a. fechaactivacion as dateactivation FROM auxiliares a WHERE replace((to_char(idorigen,'099999')||to_char(idgrupo,'09')||to_char(idsocio,'099999')),' ','')='" + customerId + "'";
        try {
            query = em.createNativeQuery(consulta);
            lista = query.getResultList();
            Object[] ok = null;
            for (int i = 0; i < lista.size(); i++) {
                ok = lista.get(i);
                accountsDTO cuentas = new accountsDTO(ok[0].toString(), ok[1].toString(), ok[2].toString(), ok[3].toString());
                listaCuentas.add(cuentas);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar cliente:" + e.getMessage());
        } finally {
            System.out.println("en finally");
            em.close();
        }
        System.out.println("Lista:" + listaCuentas);
        return listaCuentas;
    }

    public List<Object[]> getTemplates(String customerId) {
        EntityManager em = emf.createEntityManager();

        return null;
    }

    public List<Object[]> countries() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM paises");
        List<Object[]> lista = query.getResultList();
        return lista;
    }

    public customerDTO detalles(String customerId) {
        int o = Integer.parseInt(customerId.substring(0, 6));
        int g = Integer.parseInt(customerId.substring(6, 8));
        int s = Integer.parseInt(customerId.substring(8, 14));
        System.out.println("O:" + o + ", g:" + g + ", s:" + s);
        PersonasPK pk = new PersonasPK(o, g, s);
        EntityManager em = emf.createEntityManager();
        Persona personas = em.find(Persona.class, pk);
        int grupo = personas.getPersonasPK().getIdgrupo();
        String customerType = "";

        if (grupo == 1) {
            customerType = "Socio contable";
        } else if (grupo == 60) {
            customerType = "Aval no socio";
        } else if (grupo == 61) {
            customerType = "Conyuge no socio";
        } else if (grupo == 62) {
            customerType = "Aval no socio";
        } else if (grupo == 63) {
            customerType = "Beneficiario no socio";
        } else if (grupo == 64) {
            customerType = "Referencia personal no socio";
        } else if (grupo == 8) {
            customerType = "Prospecto a socio";
        } else if (grupo == 9) {
            customerType = "Aspirante";
        } else if (grupo == 10) {
            customerType = "Socio";
        } else if (grupo == 40) {
            customerType = "Socio castigado";
        } else if (grupo == 41) {
            customerType = "Socio dado de baja";
        } else if (grupo == 42) {
            customerType = "Aspirante dado de baja";
        } else if (grupo == 43) {
            customerType = "Prospecto dado de baja";
        } else if (grupo == 44) {
            customerType = "Menor dado de baja";
        } else if (grupo == 45) {
            customerType = "Ex-socio";
        } else if (grupo == 46) {
            customerType = "Ex-aspirante";
        } else if (grupo == 47) {
            customerType = "Ex-ahorrador menor";
        } else if (grupo == 20) {
            customerType = "Ahorrador menor";
        } else if (grupo == 81) {
            customerType = "Empleados";
        } else if (grupo == 48) {
            customerType = "Recursos no socio";
        } else if (grupo == 88) {
            customerType = "Personas bloqueadas cnbv";
        } else if (grupo == 66) {
            customerType = "Proveedores personas fisicas";
        } else if (grupo == 67) {
            customerType = "Proveedores personas morales";
        } else if (grupo == 49) {
            customerType = "Propietario real no socios";
        } else if (grupo == 65) {
            customerType = "Usuarios remesas";
        } else {
            customerType = "Sin nombre para el grupo";
        }
        customerDTO persona = new customerDTO(customerId, personas.getNombre(), customerType);

        return persona;
    }

    public String nombre() {
        EntityManager em = emf.createEntityManager();
        String nombre = "";
        try {
            Query query = em.createNativeQuery("SELECT nombre FROM personas limit 1");
            nombre = (String) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en buscar nombre:" + e.getMessage());
        }

        return nombre;
    }

    public void cerrar() {
        emf.close();
    }

}
