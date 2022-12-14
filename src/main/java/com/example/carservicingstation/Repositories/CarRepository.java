package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car>findAllCarsByLastNameEqualsIgnoreCase(String lastName);

    List<Car>findAllCarsByBrandNameEqualsIgnoreCase(String brandName);
}
