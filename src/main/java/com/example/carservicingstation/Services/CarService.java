package com.example.carservicingstation.Services;

import com.example.carservicingstation.Dtos.CarDto;
import com.example.carservicingstation.Model.Car;
import com.example.carservicingstation.Repositories.CarRepository;
import com.example.carservicingstation.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepos;

    public CarService(CarRepository carRepos) {
        this.carRepos = carRepos;
    }

    public List<CarDto> getAllCars(){
        List<Car> carList = carRepos.findAll();
        List<CarDto> carDtoList = new ArrayList<>();

        for(Car car:carList){
            CarDto dto = transferToCarDto(car);
            carDtoList.add(dto);
        }
        return carDtoList;
    }

    public List<CarDto> getAllCarsByLastName(String lastName){
        List<Car> carList = carRepos.findAllCarsByLastNameEqualsIgnoreCase(lastName);

        List<CarDto> carDtoList = new ArrayList<>();

        for(Car car: carList){
            CarDto dto = transferToCarDto(car);
            carDtoList.add(dto);
        }
        return carDtoList;
    }

    public List<CarDto> getAllCarsByBrandName(String brandName){
        List<Car> carList = carRepos.findAllCarsByBrandNameEqualsIgnoreCase(brandName);

        List<CarDto> carDtoList = new ArrayList<>();

        for(Car car: carList){
            CarDto dto = transferToCarDto(car);
            carDtoList.add(dto);
        }
        return carDtoList;
    }

    public CarDto registerCar(CarDto carDto){
        Car savedCar= toCar(carDto);
        this.carRepos.save(savedCar);

        return transferToCarDto(savedCar);
    }

    public CarDto updateCar(Long id, CarDto carDto) {

        if(carRepos.findById(id).isPresent()){

            Car car = carRepos.findById(id).get();

            if(!(carDto.getBrandName()==null)){car.setBrandName(carDto.getBrandName());}
            if(!(carDto.getModel()==null)){car.setModel(carDto.getModel());}
            if(!(carDto.getYearBuilt()<=0)){car.setYearBuilt(carDto.getYearBuilt());}
            if(!(carDto.getColour()==null)){car.setColour(carDto.getColour());}
            if(!(carDto.getRegistrationNo()==null)){car.setRegistrationNo(carDto.getRegistrationNo());}
            if(!(carDto.getFirstName()==null)){car.setFirstName(carDto.getFirstName());}
            if(!(carDto.getLastName()==null)){car.setLastName(carDto.getLastName());}
            if(!(carDto.getOwnersEmail()==null)){car.setOwnersEmail(carDto.getOwnersEmail());}
            if(!(carDto.getOwnersPhoneNo()==null)){car.setOwnersPhoneNo(car.getOwnersPhoneNo());}

            carRepos.save(car);

            return transferToCarDto(car);
        } else {

            throw new RecordNotFoundException("Geen auto gevonden");
        }
    }

    public void deleteCar(@RequestBody Long id) {

        carRepos.deleteById(id);
    }
    public CarDto transferToCarDto(Car car){
        CarDto dto = new CarDto();

        dto.setId(car.getId());
        dto.setBrandName(car.getBrandName());
        dto.setColour(car.getColour());
        dto.setModel(car.getModel());
        dto.setRegistrationNo(car.getRegistrationNo());
        dto.setYearBuilt(car.getYearBuilt());
        dto.setFirstName(car.getFirstName());
        dto.setLastName(car.getLastName());
        dto.setOwnersEmail(car.getOwnersEmail());
        dto.setOwnersPhoneNo(car.getOwnersPhoneNo());

        return dto;
    }

    public Car toCar(CarDto carDto){
        Car car = new Car();

        car.setBrandName(carDto.getBrandName());
        car.setModel(carDto.getModel());
        car.setColour(carDto.getColour());
        car.setRegistrationNo(carDto.getRegistrationNo());
        car.setYearBuilt(carDto.getYearBuilt());
        car.setFirstName(carDto.getFirstName());
        car.setLastName(carDto.getLastName());
        car.setOwnersPhoneNo(carDto.getOwnersPhoneNo());
        car.setOwnersEmail(carDto.getOwnersEmail());

        return car;
    }
}
