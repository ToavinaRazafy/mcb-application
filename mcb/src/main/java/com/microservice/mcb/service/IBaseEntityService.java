/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.mcb.service;

import com.microservice.mcb.entity.BusinessActivity;
import com.microservice.mcb.entity.Country;
import com.microservice.mcb.entity.Purpose;
import com.microservice.mcb.entity.Status;
import com.microservice.mcb.entity.TypeEntity;
import java.util.List;

public interface IBaseEntityService {

    List<Purpose> getAllPurpose();

    List<TypeEntity> getAllTypeEntity();

    List<BusinessActivity> getAllBusinessActivity();

    List<Country> getAllCountry();

    List<Status> getAllStatus();
}
