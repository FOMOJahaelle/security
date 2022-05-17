/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derteuffel.security.dao;

import com.derteuffel.security.entites.User;
import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jahaelle
 */

public interface UserDao extends JpaRepository <User, String> {
    
   public Page<User>findByUsername(String username,Pageable p);
   public Page<User> findByEmail(String email,Pageable p);
   public List<User> findByEnable(boolean enable,Pageable p);
   public List<User> findByRole(Role role,Pageable p);
}
