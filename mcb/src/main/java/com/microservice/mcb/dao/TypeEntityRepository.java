/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.microservice.mcb.dao;

import com.microservice.mcb.entity.TypeEntity;
import org.springframework.stereotype.Repository;

@Repository("typeEntityRepository")
public interface TypeEntityRepository extends BaseEntityRepository<TypeEntity, Integer> {
    
}
