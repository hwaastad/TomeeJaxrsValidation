/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.service;

import javax.ejb.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.waastad.tomeejaxrsvalidation.model.ExtendedModel;
import org.waastad.tomeejaxrsvalidation.model.LoginModel;

/**
 *
 * @author helge
 */
@Path("auth")
public class AuthService {

    @POST
    @Path("simple")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Valid LoginModel model) {
        return Response.ok().build();
    }
    
    @POST
    @Path("extended")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginExtended(@Valid ExtendedModel model) {
        return Response.ok().build();
    }
}
