package com.medicfast.bo;

import com.medicfast.dao.SenhaDAO;
import com.medicfast.model.Senha;

import javax.enterprise.context.Dependent;

/**
 * Created by Kennedy on 17/10/2015.
 */
@Dependent
public class SenhaBO {

    private SenhaDAO dao = new SenhaDAO();

    public SenhaBO() {
    }

    public Senha salvar(Senha s){
        return dao.salvar(s);
    }


    public Senha buscarPorId(Integer senha) {
        return dao.buscarPorId(senha);
    }
}
