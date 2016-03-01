
package com.medicfast.dao;

import com.medicfast.session.SessionEntity;
import com.medicfast.model.Medico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Criteria;
import org.hibernate.Session;


public class MedicoDAO {
    
    static EntityManager em;
    static EntityTransaction et;
    
    public MedicoDAO() {
        em = SessionEntity.getEntity();
    }
    
    
    
    public String salvar(Medico m){
        et = em.getTransaction();
        try{
        et.begin();
        em.merge(m);
        et.commit();
               
        return "Salvo com Sucesso !";
        
        }catch(Exception e){
            et.rollback(); // Desfaz o que foi feito em caso de erro
            return "Não foi possivel Salvar!  Erro = " +e.getMessage();
        }
    }
    
    public String excluir (Medico m){
        et = em.getTransaction();
        try{
            et.begin();
            em.remove(em.getReference(Medico.class, m.getId()));
            et.commit();
         return "Removido com Sucesso !";
        
        }catch(Exception e){
            et.rollback(); // Desfaz o que foi feito em caso de erro
            return "Não foi possivel Remover!  Erro = " +e.getMessage();
        }
    }
    
     public List<Medico> buscarMedico() {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Medico.class);
        return criteria.list();
    }
    
    
    
}
