package com.medicfast.dao;

import com.medicfast.model.Especialidade;
import com.medicfast.model.Medico;
import com.medicfast.session.SessionEntity;
import com.medicfast.model.PontoAtendimento;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class PontoAtendimentoDAO {

    static EntityManager em;
    static EntityTransaction et;

    public PontoAtendimentoDAO() {
        em = SessionEntity.getEntity();

    }

    public String salvar(PontoAtendimento pt) {
        et = em.getTransaction();
        try {
            et.begin();
            em.merge(pt);
            et.commit();

            return "Salvo com Sucesso !";

        } catch (Exception e) {
            et.rollback(); // Desfaz o que foi feito em caso de erro
            return "Não foi possivel Salvar!  Erro = " + e.getMessage();
        }
    }

    public String excluir(PontoAtendimento pa) {
        et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.getReference(PontoAtendimento.class, pa.getId()));
            et.commit();

            return "Removido com Sucesso !";

        } catch (Exception e) {
            et.rollback(); // Desfaz o que foi feito em caso de erro
            return "Não foi possivel remover!  Erro = " + e.getMessage();
        }
    }

    public List<PontoAtendimento> buscarPontos() {

        Session session = (Session) em.getDelegate();
        //Query query = session.createQuery("Select  ponto.id,ponto.bairro, ponto.nome, ponto.rua, ponto.numero , ponto.complemento , ponto.telefone from PontoAtendimento as ponto");
        //List<PontoAtendimento> pontos = query.list();
        //return pontos;

        Criteria criteria = session.createCriteria(PontoAtendimento.class);
        return criteria.list();
    }

    public List<PontoAtendimento> buscarPontoPorNome(String text) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(PontoAtendimento.class);
        criteria.add(Restrictions.ilike("nome","%"+text+"%"));
        return criteria.list();
    }

    public List<PontoAtendimento> buscarPontoPorEspecialidade(Integer especialidade){
        /*
            // SQL
            select p.nome ,m.nome, e.nome,e.id from pontoAtendimento as p
            inner join pontoAtendimento_medico pm on pm.pontoatendimento_id = p.id
            inner join medico m on m.id = pm.medico_id
            inner join medico_especialidade me on me.medico_id = m.id
            inner join especialidade e on me.especialidade_id = e.id where e.id = 1;

            //Hibernate
            Select  ponto  from PontoAtendimento as ponto"
            inner join  ponto.medico as pm "
            inner join  pm.especialidade as me "
            where me.id = :idEspecialidade
        * */

        Session session = (Session) em.getDelegate();
        Query query = session.createQuery("Select  ponto from PontoAtendimento as ponto" +
                "            inner join  ponto.medico as pm " +
                "            inner join  pm.atendendoComo as me " +
                "            where me.id = :idEspecialidade and pm.LocalAtendimento = ponto.id");

        query.setParameter("idEspecialidade", especialidade);
        List<PontoAtendimento> pontos = query.list();
        return pontos;



    }


    public List<PontoAtendimento> buscarPontoPorMedicamento(Integer medicamento){
        /*
            // SQL
            select p.nome ,m.nome, e.nome,e.id from pontoAtendimento as p
            inner join pontoAtendimento_medico pm on pm.pontoatendimento_id = p.id
            inner join medico m on m.id = pm.medico_id
            inner join medico_especialidade me on me.medico_id = m.id
            inner join especialidade e on me.especialidade_id = e.id where e.id = 1;

            //Hibernate
            Select  ponto  from PontoAtendimento as ponto"
            inner join  ponto.medico as pm "
            inner join  pm.especialidade as me "
            where me.id = :idEspecialidade
        * */

        Session session = (Session) em.getDelegate();
        Query query = session.createQuery("Select  ponto  from PontoAtendimento as ponto" +
                "            inner join  ponto.medicamento as pm " +
                "            where pm.id = :idMedicamento");

        query.setParameter("idMedicamento",medicamento);
        List<PontoAtendimento> pontos = query.list();
        return pontos;



    }


}
