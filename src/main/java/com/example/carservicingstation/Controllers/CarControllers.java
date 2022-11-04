package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Dtos.CarDto;
import com.example.carservicingstation.Services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CarControllers {

    private final CarService carService;

    public CarControllers(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/lastname")
    public ResponseEntity<List<CarDto>> getAllCarsByLastName(@RequestParam(value="lastName", required = false) Optional<String> lastName){
        List<CarDto> dtos;

        if(!lastName.isPresent()){
            dtos = carService.getAllCars();
        } else {
            dtos = carService.getAllCarsByLastName(lastName.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/cars/brand")
    public ResponseEntity<List<CarDto>> getAllCarsByBrandName(@RequestParam(value="brandName", required = false) Optional<String> brandName){
        List<CarDto> dtos;

        if(!brandName.isPresent()){
            dtos = carService.getAllCars();
        } else {
            dtos = carService.getAllCarsByBrandName(brandName.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/cars")
    public ResponseEntity<Object> registerCar(@RequestBody CarDto carDto) {
        CarDto dto= carService.registerCar(carDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable Long id, @RequestBody CarDto updateCar){

        CarDto dto = carService.updateCar(id, updateCar);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping ("/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);

        return ResponseEntity.noContent().build();
    }



}
