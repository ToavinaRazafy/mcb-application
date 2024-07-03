/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservice.user.service;

import com.microservice.user.entity.User;


public interface LoginService {
    String authenticate(User login)throws Exception ; 
}
