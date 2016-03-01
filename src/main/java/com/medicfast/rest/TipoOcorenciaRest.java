package com.medicfast.rest;

import com.medicfast.bo.TipoOcorrenciaBO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Kennedy on 23/10/2015.
 */
@Path("/ocorrencia")
public class TipoOcorenciaRest {
    @Inject
    TipoOcorrenciaBO bo = new TipoOcorrenciaBO();

    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){

        return Response.status(200).entity(bo.listaOcorrendia()).build();
    }

}
