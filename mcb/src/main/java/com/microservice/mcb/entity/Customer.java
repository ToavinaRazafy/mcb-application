/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.microservice.mcb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "purpose_id", referencedColumnName = "id")
    private Purpose purpose;
    
    @Column(name = "company_name")
    private String companyName;
    
    @ManyToOne
    @JoinColumn(name = "type_entity_id", referencedColumnName = "id")
    private TypeEntity typeEntity;
    
    @ManyToOne
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private BusinessActivity businessActivity;
    
    @Column(name = "system_banking")
    private String systemBanking;
    
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
    
    @Column(name = "registration_number")
    private String registrationNumber;
    
    @Column(name = "date_incorporation", updatable = false)
    private Timestamp dateIncorporation;
    
    @Column(name = "director_name")
    private String directorName;
    
    @Column(name = "passport_number")
    private String passportNumber;
    
    @Column(name = "designated_name")
    private String designatedName;
    
    @Column(name = "email")
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public TypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(TypeEntity typeEntity) {
        this.typeEntity = typeEntity;
    }

    public BusinessActivity getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(BusinessActivity businessActivity) {
        this.businessActivity = businessActivity;
    }

    public String getSystemBanking() {
        return systemBanking;
    }

    public void setSystemBanking(String systemBanking) {
        this.systemBanking = systemBanking;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Timestamp getDateIncorporation() {
        return dateIncorporation;
    }

    public void setDateIncorporation(Timestamp dateIncorporation) {
        this.dateIncorporation = dateIncorporation;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDesignatedName() {
        return designatedName;
    }

    public void setDesignatedName(String designatedName) {
        this.designatedName = designatedName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer() {
    }
    
    
    
}
