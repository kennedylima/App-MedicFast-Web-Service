package com.medicfast.bo;

import com.medicfast.dao.EspecialidadeDAO;
import com.medicfast.model.Especialidade;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Kennedy on 20/10/2015.
 */
@Dependent
public class EspecialidadeBO {

    EspecialidadeDAO dao = new EspecialidadeDAO();

    public List<Especialidade> listarEspecialidade() {
        return dao.listarTodos();
    }

    public Especialidade buscarEspecialidadePorId(Integer idEspecialidade){
        return dao.buscarPorId(idEspecialidade);
    }


    public List<Especialidade> listarEspecialidadePorPonto(Integer idPonto) {
        return dao.buscarEspecialidadePorPonto(idPonto);
    }
}
