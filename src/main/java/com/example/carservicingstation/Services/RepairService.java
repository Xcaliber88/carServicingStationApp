package com.example.carservicingstation.Services;


import com.example.carservicingstation.Dtos.RepairDto;
import com.example.carservicingstation.Model.Repair;
import com.example.carservicingstation.Repositories.JobDescriptionRepository;
import com.example.carservicingstation.Repositories.RepairRepository;
import com.example.carservicingstation.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    private final RepairRepository repairRepos;

    private final JobDescriptionRepository jobRepos;

    private final RepairJobDescriptionService repairJobService;

    public RepairService(RepairRepository repairRepos, JobDescriptionRepository jobRepos, RepairJobDescriptionService repairJobService) {
        this.repairRepos = repairRepos;
        this.jobRepos = jobRepos;
        this.repairJobService = repairJobService;
    }

    public List<RepairDto> getAllRepair() {

        List<Repair> repairList = repairRepos.findAll();
        List<RepairDto> repairDtoList = new ArrayList<>();

        for(Repair repair: repairList){
            RepairDto dto = transferToRepairDto(repair);
            repairDtoList.add(dto);
        }

        return repairDtoList;
    }

    public List<RepairDto> getRepairByRepairName(String repairName){

        List<Repair> repairList = repairRepos.findAllRepairByRepairNameEqualsIgnoreCase(repairName);
        List<RepairDto> repairDtoList = new ArrayList<>();

        for(Repair repair: repairList){
            RepairDto dto = transferToRepairDto(repair);
            repairDtoList.add(dto);
        }
        return repairDtoList;
    }

    public RepairDto getRepairById(Long id){
        if(repairRepos.findById(id).isPresent()){
            Repair repair = repairRepos.findById(id).get();
            return transferToRepairDto(repair);
        }else{
            throw new RuntimeException("Did not found repair");
        }
    }

    public RepairDto addRepair(RepairDto repairDto){

        Repair addedRepair = toRepair(repairDto);
        this.repairRepos.save(addedRepair);

        return transferToRepairDto(addedRepair);
    }

    public void deleteRepair(@RequestBody Long id) {
        Optional<Repair> optionalRepair = repairRepos.findById(id);
        if(optionalRepair==null){
            throw new RecordNotFoundException("cannot find repair");
        } else{
            repairRepos.deleteById(id);
        }
    }

    public RepairDto updateRepair(Long id, RepairDto repairDto) {

        if (repairRepos.findById(id).isPresent()) {
            Repair repair = repairRepos.findById(id).get();

            if (!(repairDto.getRepairName() == null)) {
                repair.setRepairName(repairDto.getRepairName());
            }
            if (!(repairDto.getRepairDescription() == null)) {
                repair.setRepairDescription(repairDto.getRepairDescription());
            }

            repairRepos.save(repair);

            return transferToRepairDto(repair);

        } else {
            throw new RecordNotFoundException("Auto onderdeel niet gevonden");
        }
    }

    public RepairDto transferToRepairDto(Repair repair) {

        RepairDto dto = new RepairDto();

        dto.setId(repair.getId());
        dto.setRepairName(repair.getRepairName());
        dto.setRepairDescription(repair.getRepairDescription());

        return dto;
    }

    public Repair toRepair (RepairDto repairDto){

        Repair repair = new Repair();

        repair.setId(repairDto.getId());
        repair.setRepairName(repairDto.getRepairName());
        repair.setRepairDescription(repairDto.getRepairDescription());

        return repair;
    }
}
