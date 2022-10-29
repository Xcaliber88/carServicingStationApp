package com.example.carservicingstation.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_parts")
public class CarPart {

    @Id
    @GeneratedValue
    private Long id;

    private String partName;

    private String partCategory;

    private String partDescription;

    private String originalStock;

    private String sold;

    private String weight;

    private double price;
    @ManyToOne
    JobDescription job;
    public CarPart(){}

    public CarPart(Long id, String partName, String partCategory, String partDescription, String originalStock, String sold, String weight, double price) {
        this.id = id;
        this.partName = partName;
        this.partCategory = partCategory;
        this.partDescription = partDescription;
        this.originalStock = originalStock;
        this.sold = sold;
        this.weight = weight;
        this.price = price;
    }

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

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
