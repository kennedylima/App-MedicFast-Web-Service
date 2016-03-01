package com.medicfast.bo;

import com.medicfast.dao.TipoOcorrenciaDAO;
import com.medicfast.model.TipoOcorrencia;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Kennedy on 23/10/2015.
 */
@Dependent
public class TipoOcorrenciaBO {
    private TipoOcorrenciaDAO dao = new TipoOcorrenciaDAO();

    public TipoOcorrenciaBO() {
    }

    public List<TipoOcorrencia> listaOcorrendia(){
        return dao.buscarOcorrencia();
    }
}
