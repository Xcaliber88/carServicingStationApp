package com.example.carservicingstation.Services;

import com.example.carservicingstation.Dtos.CarDto;
import com.example.carservicingstation.Model.Car;
import com.example.carservicingstation.Repositories.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    CarRepository carRepos;

    @InjectMocks
    CarService carService;

    @Captor
    ArgumentCaptor<Car> captor;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
//    @Disabled
    void shouldRetrieveAllCars() {
        Car car1 = new Car("mercedes","C180", 2020, "Metalic_black","K-345-JL","Jan","Jansen","JanJansen@hotmail.com", "31612345678" );
        Car car2 = new Car("BMW", "X6M", 2022,"Metalic_white", "R-543-KK","Kees", "Koters", "Keeskoters@gmail.com", "31652987321");
        Car car3 = new Car("Audi", "Etron_55", 2019, "Metalic_blue", "J-888-PK", "Willem", "de_Wit", "Willemdewit@yahoo.com", "31658654321");

        when(carRepos.findAll()).thenReturn(List.of(car1,car2,car3));

       CarDto carDto01 = new CarDto ("mercedes","C180", 2020, "Metalic_black","K-345-JL","Jan","Jansen","JanJansen@hotmail.com", "31612345678" );
       CarDto carDto02 = new CarDto ("BMW", "X6M", 2022,"Metalic_white", "R-543-KK","Kees", "Koters", "Keeskoters@gmail.com", "31652987321");
       CarDto carDto03 = new CarDto ("Audi", "Etron_55", 2019, "Metalic_blue", "J-888-PK", "Willem", "de_Wit", "Willemdewit@yahoo.com", "31658654321");

        List<CarDto> carsFound = carService.getAllCars();

        assertEquals(carDto01, carsFound.get(0));
        assertEquals(carDto02, carsFound.get(1));
        assertEquals(carDto03, carsFound.get(2));
    }

    @Test
    @Disabled
    void getAllCarsByLastName() {
    }

    @Test
    @Disabled
    void getAllCarsByBrandName() {
    }

    @Test
    @Disabled
    void registerCar() {
    }

    @Test
    @Disabled
    void updateCar() {
    }

    @Test
    @Disabled
    void deleteCar() {
    }

    @Test
    @Disabled
    void transferToCarDto() {
    }

    @Test
    @Disabled
    void toCar() {
    }
}