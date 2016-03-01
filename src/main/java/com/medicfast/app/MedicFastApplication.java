package com.medicfast.app;

import com.medicfast.rest.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/ws")
public class MedicFastApplication extends Application {
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(PontoAtendimentoRest.class);
        classes.add(MedicamentoRest.class);
        classes.add(EspecialidadeRest.class);
        classes.add(SenhaRest.class);
        classes.add(TipoOcorenciaRest.class);
        return classes;
    }

}
