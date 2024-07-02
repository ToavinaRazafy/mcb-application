/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.microservice.mcb.service.impl;

import com.microservice.mcb.dao.BusinessActivityRepository;
import com.microservice.mcb.dao.CountryRepository;
import com.microservice.mcb.dao.PurposeRepository;
import com.microservice.mcb.dao.StatusRepository;
import com.microservice.mcb.dao.TypeEntityRepository;
import com.microservice.mcb.entity.BusinessActivity;
import com.microservice.mcb.entity.Country;
import com.microservice.mcb.entity.Purpose;
import com.microservice.mcb.entity.Status;
import com.microservice.mcb.entity.TypeEntity;
import com.microservice.mcb.service.IBaseEntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseEntityServiceImpl implements IBaseEntityService {
    
    @Autowired
    private PurposeRepository purposeRepository;
    
    @Autowired
    private TypeEntityRepository typeEntityRepository;
    
    @Autowired
    private CountryRepository countryRepository;
    
    @Autowired
    private BusinessActivityRepository businessActivityRepository;
    
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Purpose> getAllPurpose() {
        return purposeRepository.findAll();
    }

    @Override
    public List<TypeEntity> getAllTypeEntity() {
        return typeEntityRepository.findAll();
    }

    @Override
    public List<BusinessActivity> getAllBusinessActivity() {
        return businessActivityRepository.findAll();
    }

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

}
