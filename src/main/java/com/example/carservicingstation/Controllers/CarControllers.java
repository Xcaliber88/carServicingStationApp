package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Dtos.CarDto;
import com.example.carservicingstation.Services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public ResponseEntity<Object> registerCar(@Valid @RequestBody CarDto carDto, BindingResult br) {

        if(br.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError fe: br.getFieldErrors()){
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        else{

            CarDto dto= carService.registerCar(carDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(location).body(dto);
        }
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(@Valid @PathVariable Long id, @RequestBody CarDto updateCar, BindingResult br) {

        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            CarDto dto = carService.updateCar(id, updateCar);

            return ResponseEntity.ok().body(dto);
        }
    }

    @DeleteMapping ("/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);

        return ResponseEntity.noContent().build();
    }



}
