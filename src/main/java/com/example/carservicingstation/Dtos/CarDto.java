package com.example.carservicingstation.Dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class CarDto {
    private Long id;

    @NotBlank
    private String brandName;

    @NotBlank
    private String model;
    @NotNull
    private int yearBuilt;
    @NotBlank
    private String registrationNo;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String ownersEmail;
    @NotNull
    @Size(min=10, max =11)
    @Pattern(regexp="^\\d{11}$", message ="Phone number must start with country code without + and the zero in the region code")
    private String ownersPhoneNo;
    private String colour;


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

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getOwnersEmail() {
        return ownersEmail;
    }

    public void setOwnersEmail(String ownersEmail) {
        this.ownersEmail = ownersEmail;
    }

    public String getOwnersPhoneNo() {
        return ownersPhoneNo;
    }

    public void setOwnersPhoneNo(String ownersPhoneNo) {
        this.ownersPhoneNo = ownersPhoneNo;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
