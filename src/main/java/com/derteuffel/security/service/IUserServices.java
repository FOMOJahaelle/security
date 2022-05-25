/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derteuffel.security.services;

import com.derteuffel.security.entites.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jahaelle
 */
@Path("/User")
public interface IUserServices {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<User> addUser(User user);
    
    @GET
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<User> findUser(@PathParam("id") String id);
    
    @PUT
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<User> updateUser(@PathParam("id") String id, User user);
    
    @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") String id);
    
     @GET
     @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
   public ResponseEntity<Page<User>> searchByUsername( @QueryParam("username")String username,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
         
     @GET
     @Path("/searchByEmail")
    @Produces(MediaType.APPLICATION_JSON)
   public ResponseEntity<Page<User>> searchByEmail( @QueryParam("email")String email,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
   
    @GET
      @Path("/searchByRole")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<User>> searchByRole(@QueryParam("role")String role,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
  
    @GET
      @Path("/searchByEnable")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<User>> searchByEnable(@QueryParam("enable")Boolean enable,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
    
}
