/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.microservice.mcb.dao;

import com.microservice.mcb.entity.Status;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends BaseEntityRepository<Status, Integer> {

}
