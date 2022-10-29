package com.example.carservicingstation.Controllers;


import com.example.carservicingstation.Dtos.CarDto;
import com.example.carservicingstation.Dtos.CarPartDto;
import com.example.carservicingstation.Services.CarPartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CarPartControllers {

    private final CarPartService partService;

    public CarPartControllers(CarPartService partService) {
        this.partService = partService;
    }

    @GetMapping("/car_parts/name")
    public ResponseEntity<List<CarPartDto>> getAllPartsByPartName(@RequestParam(value="partName", required = false)Optional<String> partName){

        List<CarPartDto> dtos;

        if(!partName.isPresent()){
            dtos = partService.getAllParts();
        }else {
            dtos = partService.getAllPartsByPartName(partName.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("car_parts/category")
    public ResponseEntity<List<CarPartDto>> getAllPartsByCategory(@RequestParam(value = "partCategory", required = false)Optional<String>partCategory){
        List<CarPartDto> dtos;

        if(!partCategory.isPresent()){
            dtos=partService.getAllParts();
        }else{
            dtos = partService.getAllPartsByPartCategory(partCategory.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/car_parts")
    public ResponseEntity<Object> addCarPart(@RequestBody CarPartDto partDto) {
            CarPartDto dto= partService.addCarPart(partDto);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();

            return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/car_parts/{id}")
    public ResponseEntity<Object> updateCarPart(@PathVariable Long id, @RequestBody CarPartDto updatePartDto){
        CarPartDto dto = partService.updateCarPart(id, updatePartDto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/car_parts/{id}")
    public  ResponseEntity<Object> deleteCarPart(@PathVariable Long id){
        partService.deleteCarPart(id);

        return ResponseEntity.noContent().build();
    }
}
