package com.example.carservicingstation.Model;

import javax.persistence.*;

@Entity
@Table(name="Cars")
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String brandName;
    private String model;
    private int yearBuilt;
    private String colour;
    private String registrationNo;
    private String ownersFirstName;
    private String ownersLastName;
    private String ownersEmail;
    private Long ownersPhoneNo;


    public Car(){}

    public Car(String brandName, String model, int yearBuilt, String colour, String registrationNo, String ownersFirstName, String ownersLastName, String ownersEmail, Long ownersPhoneNo) {
        this.brandName = brandName;
        this.model = model;
        this.yearBuilt = yearBuilt;
        this.colour = colour;
        this.registrationNo = registrationNo;
        this.ownersFirstName = ownersFirstName;
        this.ownersLastName = ownersLastName;
        this.ownersEmail = ownersEmail;
        this.ownersPhoneNo = ownersPhoneNo;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getOwnersFirstName() {
        return ownersFirstName;
    }

    public void setOwnersFirstName(String ownersFirstName) {
        this.ownersFirstName = ownersFirstName;
    }

    public String getOwnersLastName() {
        return ownersLastName;
    }

    public void setOwnersLastName(String ownersLastName) {
        this.ownersLastName = ownersLastName;
    }

    public String getOwnersEmail() {
        return ownersEmail;
    }

    public void setOwnersEmail(String ownersEmail) {
        this.ownersEmail = ownersEmail;
    }

    public Long getOwnersPhoneNo() {
        return ownersPhoneNo;
    }

    public void setOwnersPhoneNo(Long ownersPhoneNo) {
        this.ownersPhoneNo = ownersPhoneNo;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
