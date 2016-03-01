
package com.medicfast.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import javax.persistence.Persistence;


public class SessionEntity {
    static EntityManager em ;
    static EntityTransaction et;
    
    public static EntityManager getEntity(){
        EntityManagerFactory mf = Persistence.createEntityManagerFactory("MedicFastPU");
        em = mf.createEntityManager();
        return em;
    }
    
}
