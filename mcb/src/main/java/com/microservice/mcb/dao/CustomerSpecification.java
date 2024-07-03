/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.mcb.dao;

import com.microservice.mcb.entity.DashboardView;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {

    public static Specification<DashboardView> hasCompanyName(String companyName) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("companyName"), "%" + companyName + "%");
    }

    public static Specification<DashboardView> hasTypeEntity(String typeEntity) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("typeEntity"), "%" + typeEntity + "%");
    }

    public static Specification<DashboardView> hasBusinessActivity(String businessActivity) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("businessActivity"), "%" + businessActivity + "%");
    }

    public static Specification<DashboardView> hasCountry(String country) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("country"), "%" + country + "%");
    }
    
    public static Specification<DashboardView> hasRegistrationNumber(String regitrationNumber) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("regitrationNumber"), "%" + regitrationNumber + "%");
    }
    public static Specification<DashboardView> hasStatus(String status) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get("status"), "%" + status + "%");
    }
}
