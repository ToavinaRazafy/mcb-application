/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.mcb.service;

import com.microservice.mcb.entity.Customer;
import com.microservice.mcb.entity.DashboardView;
import com.microservice.mcb.util.CustomerSearchCriteria;
import org.springframework.data.domain.Page;

public interface ICustomerService {

    Page<DashboardView> getDashboardView(CustomerSearchCriteria customerSearchCriteria, int page, int size);

    Customer findById(Integer customerId);

    void saveCustomer(Customer customer);

}
