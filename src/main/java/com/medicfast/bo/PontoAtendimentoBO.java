package com.medicfast.bo;

import com.medicfast.dao.PontoAtendimentoDAO;
import com.medicfast.model.Especialidade;
import com.medicfast.model.PontoAtendimento;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Kennedy on 17/10/2015.
 */
@Dependent
public class PontoAtendimentoBO {
    private PontoAtendimentoDAO dao = new PontoAtendimentoDAO();

    public PontoAtendimentoBO() {

    }

    public List<PontoAtendimento> listar(){
        return dao.buscarPontos();
    }

    public List<PontoAtendimento> listarPorEspecialidade(Integer especialidade) { return dao.buscarPontoPorEspecialidade(especialidade); }
    public List<PontoAtendimento> listarPorMedicamento(Integer medicamento) { return dao.buscarPontoPorMedicamento(medicamento); }

    //public List<PontoAtendimento> listarEspecialidadePorPonto(Integer idPonto) { return dao.buscarEspecialidadePorPonto(idPonto);}
}
