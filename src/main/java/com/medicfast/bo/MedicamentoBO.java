package com.medicfast.bo;

import com.medicfast.dao.MedicamentoDAO;
import com.medicfast.model.Medicamento;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Kennedy on 17/10/2015.
 */
@Dependent
public class MedicamentoBO {

    private MedicamentoDAO dao = new MedicamentoDAO();

    public MedicamentoBO() {
    }

    public List<Medicamento> listar(){
        return dao.buscarMedicamentos();
    }
}
