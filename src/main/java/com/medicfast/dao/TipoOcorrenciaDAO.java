package com.medicfast.dao;

import com.medicfast.model.TipoOcorrencia;
import com.medicfast.session.SessionEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by Kennedy on 23/10/2015.
 */
public class TipoOcorrenciaDAO {

    static EntityManager em;
    static EntityTransaction et;

    public TipoOcorrenciaDAO() {
        em = SessionEntity.getEntity();
    }

    public List<TipoOcorrencia> buscarOcorrencia() {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(TipoOcorrencia.class);
        return criteria.list();

    }
}
