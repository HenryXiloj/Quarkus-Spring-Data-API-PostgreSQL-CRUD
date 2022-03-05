package com.henry.resource;

import com.henry.model.User;
import com.henry.service.UserService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<User> findAll() {
        return userService.findAll();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam long id) {
        userService.delete(id);
    }

    @POST
    @Path("/name/{name}/age/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public User create(@PathParam String name, @PathParam Integer age) {

        return userService.create(name, age);
    }

    @PUT
    @Path("/id/{id}/age/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public User changeAge(@PathParam Long id, @PathParam Integer age) {
        return userService.changeAge(id, age);
    }

    @GET
    @Path("/age/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findByAge(@PathParam Integer age) {

        return userService.findByAge(age);
    }
}
