package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.Car;
import com.example.carservicingstation.Model.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {

    List<CarPart>findAllCarPartsByPartNameEqualsIgnoreCase(String partName);
    List<CarPart>findAllCarPartsByPartCategoryEqualsIgnoreCase(String partCategory);
}
