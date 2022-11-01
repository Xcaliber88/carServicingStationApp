package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Dtos.JobDto;
import com.example.carservicingstation.Dtos.RepairDto;
import com.example.carservicingstation.Repositories.RepairRepository;
import com.example.carservicingstation.Services.RepairJobDescriptionService;
import com.example.carservicingstation.Services.RepairService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class RepairControllers {

    private final RepairService service;
    private final RepairRepository repairRepos;

    private final RepairJobDescriptionService repairJobService;

    public RepairControllers(RepairService service, RepairRepository repairRepos, RepairJobDescriptionService repairJobService) {
        this.service = service;
        this.repairRepos = repairRepos;
        this.repairJobService = repairJobService;
    }

    @GetMapping("/repairs")
    public ResponseEntity<List<RepairDto>> getAllRepair(@RequestParam(value = "repair_name", required = false) Optional<String> repairName){

        List<RepairDto> dtos;

        if(!repairName.isPresent()){
            dtos = service.getAllRepair();
        }else {
            dtos = service.getRepairByRepairName(repairName.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/repairs/{id}")
    public ResponseEntity<Object> getRepair(@PathVariable("id") Long id) {
        RepairDto repairDto = service.getRepairById(id);

        return ResponseEntity.ok().body(repairDto);
    }

    @PostMapping("/repairs")
    public ResponseEntity<Object>addRepair(@RequestBody RepairDto repairDto){
        RepairDto dto = service.addRepair(repairDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(location).body(dto);
    }

    @DeleteMapping("/repairs/{id}")
    public ResponseEntity<Object> deleteRepair(@PathVariable Long id){
        service.deleteRepair(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/repairs/{id}")
    public ResponseEntity<Object> updateRepair(@PathVariable Long id, @RequestBody RepairDto updatedRepair) {

        RepairDto dto = service.updateRepair(id, updatedRepair);

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/repairs/jobs/{repairId}")
    public Collection<JobDto> getJobByRepairId(@PathVariable("repairId") Long repairId){
        return repairJobService.getRepairJobDescriptionByRepairId(repairId);
    }


}
