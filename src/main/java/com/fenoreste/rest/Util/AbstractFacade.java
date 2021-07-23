/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.Util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wilmer
 */
public abstract class AbstractFacade<T> {
    EntityManager em;
    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public static EntityManagerFactory conexion() {
    	System.out.println("Llegando a abstract");
        Fichero_Configuraciones  datos = new Fichero_Configuraciones();
        EntityManagerFactory emf=null;
        JPAUtil jpa=new JPAUtil();
        emf=jpa.getEntityManagerFactory(datos.getHost(),datos.getDatabase());
        return emf;
    }
     public EntityManagerFactory conexion2() {
    	System.out.println("Llegando a abstract");
        Fichero_Configuraciones  datos = new Fichero_Configuraciones();
        EntityManagerFactory emf=null;
        JPAUtil jpa=new JPAUtil();
        emf=jpa.getEntityManagerFactory(datos.getHost(),datos.getDatabase());
        return emf;
    }
    

    public int inserta(T entity) {
        EntityManagerFactory emf=conexion();
        em = emf.createEntityManager();  
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en inserta: " + e.getMessage());
            em.getTransaction().rollback();
            return 0;
        } finally {
            em.close();
        }
        return 1;
     }

    public int actualiza(T entity) {
        EntityManagerFactory emf=conexion();
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en actualiza : " + e.getMessage());
            em.getTransaction().rollback();
            return 0;
        } finally {
            em.close();
        }
        return 1;
    }

    public int elimina(T entity) {
        EntityManagerFactory emf=conexion();
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en elimina : " + e.getMessage());
            em.getTransaction().rollback();
            return 0;
        } finally {
            em.close();
        }
        return 1;
    }

    public T find(Object id) {
        EntityManagerFactory emf=conexion();
        em = emf.createEntityManager();
        T find = em.find(entityClass, id);
        em.close();
        return find;
    }

    public List<T> findAll() {
       EntityManagerFactory emf=conexion();
       em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        List lista = em.createQuery(cq).getResultList();
        em.close();
        return lista;
    }

    public List<T> findRange(int[] range) {
        EntityManagerFactory emf=conexion();
        em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        List rango = q.getResultList();
        em.close();
        return rango;
    }

    public int count() {
       EntityManagerFactory emf=conexion();
       em = emf.createEntityManager();
       CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
       Root<T> rt = cq.from(entityClass);
       cq.select(em.getCriteriaBuilder().count(rt));
       Query q = em.createQuery(cq);
       int conteo = ((Long) q.getSingleResult()).intValue();
       em.close();
       return conteo;
    }

}
