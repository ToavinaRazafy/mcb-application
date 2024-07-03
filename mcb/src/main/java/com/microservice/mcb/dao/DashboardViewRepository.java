/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.microservice.mcb.dao;

import com.microservice.mcb.entity.DashboardView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardViewRepository extends JpaRepository<DashboardView, Integer>, JpaSpecificationExecutor<DashboardView> {
    
}
