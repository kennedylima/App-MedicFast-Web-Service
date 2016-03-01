
package com.medicfast.dao;


import com.medicfast.model.Especialidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.medicfast.model.PontoAtendimento;
import com.medicfast.session.SessionEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class EspecialidadeDAO {
    
    private static EntityManager em;
    private static EntityTransaction et;
    
    public EspecialidadeDAO() {
        em = SessionEntity.getEntity();
        
    }
    
    
    
    public String salvar(Especialidade e) {
        et = em.getTransaction();
        try{
            et.begin();
            em.merge(e);
            et.commit();
            return "Salvo com Sucesso !" ;
            
        }catch(Exception ex){
            et.rollback();
            return "Erro ao Salvar" + ex.getMessage();
        }
        
    }
    
    public String excluir(Especialidade e) {
        et = em.getTransaction();
        try{
            et.begin();
            em.remove(em.getReference(Especialidade.class, e.getId()));
            et.commit();
         return "Removido com Sucesso !";
        
        }catch(Exception ex){
            //et.rollback(); // Desfaz o que foi feito em caso de erro
            //System.out.println(ex.getMessage());
            return "Não foi possivel remover, pois há médicos cadastrados com essa especialidade";
        }
    }
    public List<Especialidade> listarTodos (){
        Session session = (Session) em.getDelegate();
        Criteria c = session.createCriteria(Especialidade.class);
        return c.list();

        /*

        Query query = session.createQuery("Select  pe  from PontoAtendimento as p" +
                "            inner join  p.medico as pm" +
                "            inner join  pm.especialidade as pe  ");


        List<Especialidade> pontos = query.list();
        return pontos;
        */
    }
    
    public List<Especialidade> buscarPorNome(String text) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Especialidade.class);
        criteria.add(Restrictions.ilike("nome","%"+text+"%"));
        return criteria.list();
    }

    public Especialidade buscarPorId(Integer idEspecialidade) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Especialidade.class);
        criteria.add(Restrictions.eq("id", idEspecialidade));
        return (Especialidade)criteria.uniqueResult();
    }

    public List<Especialidade> buscarEspecialidadePorPonto(Integer idPonto) {

        /*select e.nome , p.nome from especialidade as e
        inner join medico_especialidade me on me.especialidade_id = e.id
        inner join pontoAtendimento_medico pm on pm.medico_id = me.medico_id
        inner join pontoatendimento p on p.id = 21;*/

        Session session = (Session) em.getDelegate();


        Query query = session.createQuery("Select  pe  from PontoAtendimento as p" +
                "            inner join  p.medico as pm" +
                "            inner join  pm.atendendoComo as pe "+
                "            where pm.LocalAtendimento = :idPonto " );

        query.setParameter("idPonto", idPonto);
        List<Especialidade> pontos = query.list();
        return pontos;
    }
}
