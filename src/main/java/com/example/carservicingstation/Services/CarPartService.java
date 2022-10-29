package com.example.carservicingstation.Services;

import com.example.carservicingstation.Dtos.CarPartDto;
import com.example.carservicingstation.Model.CarPart;
import com.example.carservicingstation.Repositories.CarPartRepository;
import com.example.carservicingstation.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarPartService {

    private final CarPartRepository carPartRepos;

    public CarPartService(CarPartRepository carPartRepos) {
        this.carPartRepos = carPartRepos;
    }

    public List<CarPartDto> getAllParts(){

        List<CarPart> partList = carPartRepos.findAll();
        List<CarPartDto> CarPartDtoList = new ArrayList<>();

        for(CarPart part: partList){
            CarPartDto dto = transferToCarPartDto(part);
            CarPartDtoList.add(dto);
        }

        return CarPartDtoList;
    }
    public List<CarPartDto> getAllPartsByPartName(String partName){

        List<CarPart> partList = carPartRepos.findAllCarPartsByPartNameEqualsIgnoreCase(partName);
        List<CarPartDto> partDtoList = new ArrayList<>();

        for(CarPart part: partList){
            CarPartDto dto = transferToCarPartDto(part);
            partDtoList.add(dto);
        }
        return partDtoList;
    }
    public List<CarPartDto> getAllPartsByPartCategory(String partCategory){

        List<CarPart> partList = carPartRepos.findAllCarPartsByPartCategoryEqualsIgnoreCase(partCategory);
        List<CarPartDto> partDtoList =  new ArrayList<>();

        for (CarPart part: partList){
            CarPartDto dto = transferToCarPartDto(part);
            partDtoList.add(dto);
        }
        return partDtoList;
    }
    public CarPartDto addCarPart(CarPartDto partDto){

        CarPart savedCarPart= toPart(partDto);
        this.carPartRepos.save(savedCarPart);

        return transferToCarPartDto(savedCarPart);
    }
    public CarPartDto updateCarPart(Long id, CarPartDto partDto){

        if(carPartRepos.findById(id).isPresent()){
            CarPart carPart = carPartRepos.findById(id).get();

           // CarPart updateCarPart= toPart(partDto);
            //updateCarPart.setId(carPart.getId());

            if(!(partDto.getPartName()==null)){carPart.setPartName(partDto.getPartName());}
            if(!(partDto.getPartCategory()==null)){carPart.setPartCategory(partDto.getPartCategory());}
            if(!(partDto.getPartDescription()==null)){carPart.setPartDescription(partDto.getPartDescription());}
            if(!(partDto.getOriginalStock()==null)){carPart.setOriginalStock(partDto.getOriginalStock());}
            if(!(partDto.getSold()==null)){carPart.setSold(partDto.getSold());}
            if(!(partDto.getWeight()==null)){carPart.setWeight(partDto.getWeight());}
            if(!(partDto.getPrice()<=0)){carPart.setPrice(partDto.getPrice());}

            carPartRepos.save(carPart);

            return transferToCarPartDto(carPart);

        }else {
            throw new RecordNotFoundException("Auto onderdeel niet gevonden");
        }
    }
    public void deleteCarPart(@RequestBody Long id){

        carPartRepos.deleteById(id);
    }
    public static CarPartDto transferToCarPartDto(CarPart part){

        CarPartDto dto= new CarPartDto();

        dto.setId(part.getId());
        dto.setPartCategory(part.getPartCategory());
        dto.setPartName(part.getPartName());
        dto.setPartDescription(part.getPartDescription());
        dto.setPrice(part.getPrice());
        dto.setWeight(part.getWeight());
        dto.setOriginalStock(part.getOriginalStock());
        dto.setSold(part.getSold());

        return dto;
    }
    public CarPart toPart(CarPartDto partDto){

        CarPart part = new CarPart();

        part.setPartName(partDto.getPartName());
        part.setPartCategory(partDto.getPartCategory());
        part.setPartDescription(partDto.getPartDescription());
        part.setWeight(partDto.getWeight());
        part.setOriginalStock(partDto.getOriginalStock());
        part.setSold(partDto.getSold());
        part.setPrice(partDto.getPrice());

        return part;
    }
}
