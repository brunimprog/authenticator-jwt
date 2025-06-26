package br.bruno.controller;

import java.util.HashMap;
import java.util.Map;

import br.bruno.models.Users;
import br.bruno.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {
    
    @Inject
    private UserService userService;

    @POST
    @Path("/register")
    public Response register(Users user){
        try {
            userService.registerUser(user);
            Map<String, String> responseMessage = new HashMap<>();
            responseMessage.put("message", "Usuário registrado. Verifique seu email para ativar a conta.");
            return Response.status(Response.Status.CREATED).entity(responseMessage).build();
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("message",e.getMessage());
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(errorMessage).build();
        }
    }
}
