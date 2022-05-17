 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derteuffel.security.services.impl;

import com.derteuffel.security.dao.UserDao;
import com.derteuffel.security.entites.User;
import com.derteuffel.security.services.IUserServices;
import java.net.URI;
import javax.management.relation.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author jahaelle
 */
public abstract class UserServices implements IUserServices {
    @Autowired
    private UserDao userDao; 
     
       @Override
    public ResponseEntity<User> addUser(User user) {
       User u = userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(u.equals(u))
                .toUri();
        return ResponseEntity.created(location).body(u);
    }
  
    @Override
    public ResponseEntity<User> findUser(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity<User> updateUser(String id, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String id) {
         userDao.deleteById(id);
    }
    
  @Override
    public ResponseEntity<Page<User>> searchByUsername(String username,int p, int size) {
      return (ResponseEntity<Page<User>>) userDao.findByUsername("%" +username + "%", PageRequest.of(p, size));
    }

    @Override
    public ResponseEntity<Page<User>> searchByEmail(String email, int page, int size) {
        return (ResponseEntity<Page<User>>) userDao.findByEmail("%" +email + "%", PageRequest.of(page, size)); 
    }

    public ResponseEntity<Page<User>> searchByRole(Role role, int page, int size) {
       return (ResponseEntity<Page<User>>)userDao.findByRole(role, PageRequest.of(page, size)); 
    }

}
