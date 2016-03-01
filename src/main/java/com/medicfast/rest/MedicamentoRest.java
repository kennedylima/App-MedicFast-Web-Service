package com.medicfast.rest;

import com.medicfast.bo.MedicamentoBO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/medicamento")
public class MedicamentoRest {

    @Inject
    MedicamentoBO bo = new MedicamentoBO();

    @GET
    @Path("/listar")
    @Produces("application/json")
    public Response listar(){ return Response.status(200).entity(bo.listar()).build(); }
}
