package com.medicfast.dao;

import com.medicfast.model.Senha;
import com.medicfast.session.SessionEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kennedy on 17/10/2015.
 */
public class SenhaDAO {

    static EntityManager em;
    static EntityTransaction et;

    public SenhaDAO() {
        em = SessionEntity.getEntity();
    }

    public Senha salvar(Senha s) {
        et = em.getTransaction();

        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        java.util.Date data = new java.util.Date();
        java.sql.Date data1 = new java.sql.Date(data.getTime());
        s.setData(data1.toString());

        System.err.println("Data ----->" + s.getData());
        java.sql.Time hora = new  java.sql.Time(cal.getTimeInMillis());
        s.setHorario(hora.toString());
        System.err.println("Hora ----->" + s.getHorario());

        try{
            et.begin();
            s = em.merge(s);
            et.commit();

            return s;

        }catch (Exception ex){
            ex.getMessage();
        }
        return null;
    }

    public Senha buscarPorId(Integer senha) {
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Senha.class);
        criteria.add(Restrictions.eq("numero", senha));
        return (Senha)criteria.uniqueResult();
    }


}
