/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.mcb.controller;

import com.microservice.mcb.entity.BusinessActivity;
import com.microservice.mcb.entity.Country;
import com.microservice.mcb.entity.Purpose;
import com.microservice.mcb.entity.Status;
import com.microservice.mcb.entity.TypeEntity;
import com.microservice.mcb.service.IBaseEntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mcb/entity")
public class BaseEntityController {

    @Autowired
    private IBaseEntityService baseEntityService;


    @GetMapping("/purpose")
    public List<Purpose> getAllPurpose() {
        return baseEntityService.getAllPurpose();
    }

    @GetMapping("/type_entity")
    public List<TypeEntity> getAllTypeEntity() {
        return baseEntityService.getAllTypeEntity();
    }
    
    @GetMapping("/business_activity")
    public List<BusinessActivity> getAllBusinessActivity() {
        return baseEntityService.getAllBusinessActivity();
    }
    
    @GetMapping("/country")
    public List<Country> getAllCountry() {
        return baseEntityService.getAllCountry();
    }
    
    @GetMapping("/status")
    public List<Status> getAllStatus() {
        return baseEntityService.getAllStatus();
    }

}
