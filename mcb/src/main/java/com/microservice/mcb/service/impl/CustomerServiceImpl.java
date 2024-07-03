/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.microservice.mcb.service.impl;

import com.microservice.mcb.dao.CustomerRepository;
import com.microservice.mcb.dao.CustomerSpecification;
import com.microservice.mcb.dao.DashboardViewRepository;
import com.microservice.mcb.entity.Customer;
import com.microservice.mcb.entity.DashboardView;
import com.microservice.mcb.service.ICustomerService;
import com.microservice.mcb.util.CustomerSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    
    @Autowired
    private DashboardViewRepository dashboardViewRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<DashboardView> getDashboardView(CustomerSearchCriteria customerSearchCriteria, int page, int size) {
        Specification<DashboardView> spec = Specification.where(null);

        if (customerSearchCriteria.getCompanyName()!= null && !customerSearchCriteria.getCompanyName().isEmpty()) {
            spec = spec.and(CustomerSpecification.hasCompanyName(customerSearchCriteria.getCompanyName()));
        }
         if (customerSearchCriteria.getTypeEntity()!= null && !customerSearchCriteria.getTypeEntity().isEmpty()) {
            spec = spec.and(CustomerSpecification.hasTypeEntity(customerSearchCriteria.getTypeEntity()));
        }
         if (customerSearchCriteria.getBusinessActivity()!= null && !customerSearchCriteria.getBusinessActivity().isEmpty()) {
            spec = spec.and(CustomerSpecification.hasBusinessActivity(customerSearchCriteria.getBusinessActivity()));
        }
          if (customerSearchCriteria.getCountry()!= null && !customerSearchCriteria.getCountry().isEmpty()) {
            spec = spec.and(CustomerSpecification.hasCountry(customerSearchCriteria.getCountry()));
        }
          if (customerSearchCriteria.getRegistrationNumber()!= null && !customerSearchCriteria.getRegistrationNumber().isEmpty()) {
            spec = spec.and(CustomerSpecification.hasRegistrationNumber(customerSearchCriteria.getRegistrationNumber()));
        }
          if (customerSearchCriteria.getStatus()!= null && !customerSearchCriteria.getStatus().isEmpty()) {
            spec = spec.and(CustomerSpecification.hasStatus(customerSearchCriteria.getStatus()));
        }
        Pageable pageable = PageRequest.of(page, size);
        return dashboardViewRepository.findAll(spec, pageable);
    }

    @Override
    public Customer findById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}
