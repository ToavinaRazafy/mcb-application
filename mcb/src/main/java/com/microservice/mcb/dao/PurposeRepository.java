/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservice.mcb.dao;

import com.microservice.mcb.entity.Purpose;
import org.springframework.stereotype.Repository;

@Repository("purposeRepository")
public interface PurposeRepository extends BaseEntityRepository<Purpose, Integer> {
    
}
