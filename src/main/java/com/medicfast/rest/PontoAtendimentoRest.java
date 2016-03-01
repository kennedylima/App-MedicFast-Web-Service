package com.medicfast.rest;

import com.medicfast.bo.EspecialidadeBO;
import com.medicfast.bo.PontoAtendimentoBO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Kennedy on 17/10/2015.
 */
@Path("/ponto")
public class PontoAtendimentoRest {

    @Inject
    PontoAtendimentoBO bo = new PontoAtendimentoBO();

    @GET
    @Path("/lista")
    @Produces("application/json")
    public Response lista(){

        return Response.status(200).entity(bo.listar()).build();
    }


    @GET
    @Path("/listarPorEspecialidade/{idEspecialidade}")
    @Produces("application/json")
    public Response listarPorEspecialidade(@PathParam("idEspecialidade") Integer idEspecialidade){
        return Response.status(200).entity(bo.listarPorEspecialidade(idEspecialidade)).build();
    }

    @GET
    @Path("/listarPorMedicamento/{idMedicamento}")
    @Produces("application/json")
    public Response listarPorMedicamento(@PathParam("idMedicamento") Integer idMedicamento){
        return Response.status(200).entity(bo.listarPorMedicamento(idMedicamento)).build();
    }




}
