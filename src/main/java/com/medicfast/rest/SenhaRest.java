package com.medicfast.rest;

import com.medicfast.bo.SenhaBO;
import com.medicfast.model.Senha;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Kennedy on 17/10/2015.
 */
@Path("/senha")
public class SenhaRest {

    @Inject
    SenhaBO bo = new SenhaBO();

    @POST
    @Path("/salvar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response salvar(Senha s){

        return Response.status(200).entity(bo.salvar(s)).build();
    }

    @GET
    @Path("/buscarPorId/{idSenha}")
    @Produces("application/json")
    public Response buscarPorId(@PathParam("idSenha") Integer senha){
        return Response.status(200).entity(bo.buscarPorId(senha)).build();
    }
}
