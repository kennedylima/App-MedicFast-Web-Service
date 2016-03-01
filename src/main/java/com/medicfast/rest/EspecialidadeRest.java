package com.medicfast.rest;

import com.medicfast.bo.EspecialidadeBO;
import com.medicfast.bo.PontoAtendimentoBO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Kennedy on 17/10/2015.
 */
@Path("/especialidade")
public class EspecialidadeRest {

    @Inject
    EspecialidadeBO bo = new EspecialidadeBO();

    @GET
    @Path("/listar")
    @Produces("application/json")
    public Response listarEspecialidade(){
        return Response.status(200).entity(bo.listarEspecialidade()).build();
    }

    @GET
    @Path("/listarPorPonto/{idPonto}")
    @Produces("application/json")
    public Response listarEspecialidade(@PathParam("idPonto")Integer idPonto){
        return Response.status(200).entity(bo.listarEspecialidadePorPonto(idPonto)).build();
    }
}
