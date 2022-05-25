/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.derteuffel.security.entites;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author jahaelle
 */
public class User extends Base{
         @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
     @Column(nullable = false)
    private String avatar;
    
    @Column(nullable = false)
    private String email;
    
     @Column(nullable = false)
    private Role role;
    
    @Column(nullable = false)
    private Boolean enable;
    
    @Column(nullable = false)
    private String[] authorities;
    @ManyToMany
    @JoinTable(name="USERS_ROLES")       
    private Collection <Role> roles;

    
}
