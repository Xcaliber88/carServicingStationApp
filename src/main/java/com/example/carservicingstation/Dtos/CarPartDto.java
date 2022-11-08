package com.example.carservicingstation.Dtos;

import com.example.carservicingstation.Model.FileDocument;
import com.example.carservicingstation.Model.JobDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CarPartDto {

    private Long id;

    @NotBlank
    private String partName;

    private String partCategory;

    private String partDescription;

    @NotNull
    private String originalStock;

    private String sold;

    @NotBlank
    private String weight;

    @NotNull
    private double price;

    private JobDescription job;

    private FileDocument fileDocument;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartCategory() {
        return partCategory;
    }

    public void setPartCategory(String partCategory) {
        this.partCategory = partCategory;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(String originalStock) {
        this.originalStock = originalStock;
    }

    public String getSold() {
        return sold;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public FileDocument getFileDocument() {
        return fileDocument;
    }

    public void setFileDocument(FileDocument fileDocument) {
        this.fileDocument = fileDocument;
    }
}
