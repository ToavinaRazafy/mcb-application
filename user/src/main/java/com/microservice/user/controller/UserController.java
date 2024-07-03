/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.user.controller;

import com.microservice.user.entity.User;
import com.microservice.user.object.AuthenticationRequest;
import com.microservice.user.object.AuthenticationResponse;
import com.microservice.user.service.LoginService;
import jakarta.validation.Valid;
import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
   
    @Autowired 
    private LoginService loginService ; 
    
    @GetMapping("/test")
    public ResponseEntity<?> test()
    {
        return new ResponseEntity<>("test", HttpStatus.OK) ; 
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest)
    {
        User  login = new User() ; 
        login.setUsername(authenticationRequest.getUsername());
        login.setPassword(authenticationRequest.getPassword());
        try{
            String token = this.loginService.authenticate(login) ; 
            AuthenticationResponse response = new AuthenticationResponse(token);
            return new ResponseEntity<>(response , HttpStatus.OK) ;  
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.UNAUTHORIZED) ; 
        }
        
    }
}
