/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicfast.dao;

import com.medicfast.session.SessionEntity;
import com.medicfast.model.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Kennedy
 */
public class MedicamentoDAO {

    static EntityManager em;
    static EntityTransaction et;

    public MedicamentoDAO() {

        em = SessionEntity.getEntity();
        
    }

    public String salvar(Medicamento m) {
        et = em.getTransaction();
        try {
            et.begin();
            em.merge(m);
            et.commit();
            return "Salvo com sucesso";
        } catch (Exception ex) {
            et.rollback();
            return "Erro ao salvar" + ex.getMessage();
        }

    }

    public  String excluir(Medicamento m) {
        et = em.getTransaction();
        try {
            et.begin();
            em.remove(em.getReference(Medicamento.class, m.getId()));
            et.commit();
            return "Removido com Sucesso !";

        } catch (Exception e) {
            //et.rollback(); // Desfaz o que foi feito em caso de erro
            return "Não foi possivel remover, pois um ou mais Pontos de Atendimento contém este medicamento!" ;
        }
    }

    public List<Medicamento> buscarMedicamentos() {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Medicamento.class);
        return criteria.list();
    }

    public List<Medicamento> buscarPorFabricante(String txt) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Medicamento.class);
        criteria.add(Restrictions.ilike("fabricante", "%" + txt + "%"));

        return criteria.list();
    }

    public List<Medicamento> buscarPorNome(String txt) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Medicamento.class);
        criteria.add(Restrictions.ilike("nome", "%" + txt + "%"));

        return criteria.list();
    }

}
