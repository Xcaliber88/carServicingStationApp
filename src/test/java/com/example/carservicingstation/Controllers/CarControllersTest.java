package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Dtos.CarDto;
import com.example.carservicingstation.Model.Car;
import com.example.carservicingstation.Services.CarService;
import com.example.carservicingstation.Services.CustomUserDetailsService;
import com.example.carservicingstation.Utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
@WebMvcTest(CarControllers.class)
class CarControllersTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @MockBean
    private CarService carService;

    Car car1;
    Car car2;
    Car car3;

    CarDto carDto1;
    CarDto carDto2;
    CarDto carDto3;

    @BeforeEach
    void setUp() {
        car1 = new Car ("mercedes","C180", 2020, "Metalic_black","K-345-JL","Jan","Jansen","JanJansen@hotmail.com", "31612345678" );
        car2 = new Car ("BMW", "X6M", 2022,"Metalic_white", "R-543-KK","Kees", "Koters", "KeesKoters@gmail.com", "31652987321");
        car3 = new Car ("Audi", "Etron_55", 2019, "Metalic_blue", "J-888-PK", "Willem", "de_Wit", "Willemdewit@yahoo.com", "31658654321");

        carDto1 = new CarDto ("mercedes","C180", 2020, "Metalic_black","K-345-JL","Jan","Jansen","JanJansen@hotmail.com", "31612345678" );
        carDto2 = new CarDto ("BMW", "X6M", 2022,"Metalic_white", "R-543-KK","Kees", "Koters", "KeesKoters@gmail.com", "31652987321");
        carDto3 = new CarDto ("Audi", "Etron_55", 2019, "Metalic_blue", "J-888-PK", "Willem", "de_Wit", "Willemdewit@yahoo.com", "31658654321");
    }

    @Test
//    @Disabled
    @WithMockUser(username= "evi_brown_front_office",authorities = "FRONTOFFICE")
    void getAllCarsByLastName() throws Exception {

        List<CarDto> carDtoList = new ArrayList<>();

        carDtoList.add(carDto1);
        carDtoList.add(carDto2);
        carDtoList.add(carDto3);

        Mockito.when(carService.getAllCarsByLastName("Jansen")).thenReturn(carDtoList);

        mockMvc
                .perform(MockMvcRequestBuilders.get("/cars/lastname").param("lastName", "Jansen"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brandName") .value("mercedes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].model") .value("C180"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].yearBuilt") .value(2020))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].colour") .value("Metalic_black"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].registrationNo") .value("K-345-JL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName") .value("Jan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName") .value("Jansen"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ownersEmail") .value("JanJansen@hotmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ownersPhoneNo") .value("31612345678"));

        Mockito.when(carService.getAllCarsByLastName("Koters")).thenReturn(carDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/lastname").param("lastName", "Koters"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].brandName") .value("BMW"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].model") .value("X6M"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].yearBuilt") .value(2022))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].colour") .value("Metalic_white"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].registrationNo") .value("R-543-KK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName") .value("Kees"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName") .value("Koters"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ownersEmail") .value("KeesKoters@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ownersPhoneNo") .value("31652987321"));

        Mockito.when(carService.getAllCarsByLastName("de_Wit")).thenReturn(carDtoList);

           mockMvc.perform(MockMvcRequestBuilders.get("/cars/lastname").param("lastName", "de_Wit"))
                   .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].brandName") .value("Audi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].model") .value("Etron_55"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].yearBuilt") .value(2019))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].colour") .value("Metalic_blue"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].registrationNo") .value("J-888-PK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].firstName") .value("Willem"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].lastName") .value("de_Wit"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ownersEmail") .value("Willemdewit@yahoo.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ownersPhoneNo") .value("31658654321"));

        Mockito.when(carService.getAllCarsByLastName("Is_Er_Niet")).thenReturn(carDtoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/lastname").param("lastName", "Is_Er_Niet"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brandName") .value("mercedes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].model") .value("C180"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].yearBuilt") .value(2020))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].colour") .value("Metalic_black"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].registrationNo") .value("K-345-JL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName") .value("Jan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName") .value("Jansen"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ownersEmail") .value("JanJansen@hotmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ownersPhoneNo") .value("31612345678"))

                .andExpect(MockMvcResultMatchers.jsonPath("$[1].brandName") .value("BMW"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].model") .value("X6M"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].yearBuilt") .value(2022))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].colour") .value("Metalic_white"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].registrationNo") .value("R-543-KK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName") .value("Kees"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName") .value("Koters"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ownersEmail") .value("KeesKoters@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ownersPhoneNo") .value("31652987321"))

                .andExpect(MockMvcResultMatchers.jsonPath("$[2].brandName") .value("Audi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].model") .value("Etron_55"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].yearBuilt") .value(2019))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].colour") .value("Metalic_blue"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].registrationNo") .value("J-888-PK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].firstName") .value("Willem"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].lastName") .value("de_Wit"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ownersEmail") .value("Willemdewit@yahoo.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].ownersPhoneNo") .value("31658654321"));
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
}