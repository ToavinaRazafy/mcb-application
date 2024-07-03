/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.user.service.impl;

import com.microservice.user.entity.User;
import com.microservice.user.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.user.service.LoginService;
import com.microservice.user.repository.LoginRepository;
import com.microservice.user.util.JwtTokenUtil;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginRepository loginRepository ; 
    @Autowired 
    private JwtTokenUtil jwtTokenUtil ; 
    
    @Override
    public String authenticate(User login) throws Exception {
        System.out.println("username : " + login.getUsername());
        System.out.println("Crypted password : " + PasswordUtil.hashPassword(login.getPassword()));
        User l = loginRepository.findByUsername(login.getUsername()).orElseThrow() ; 
        if(!PasswordUtil.checkPassword(login.getPassword(), l.getPassword()))
            throw new Exception("User not found") ; 
        System.out.println(login.toString());
        return this.jwtTokenUtil.generate(l) ; 
    }
        
}
