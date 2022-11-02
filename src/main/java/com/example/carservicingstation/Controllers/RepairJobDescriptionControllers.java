package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Services.JobService;
import com.example.carservicingstation.Services.RepairJobDescriptionService;
import com.example.carservicingstation.Services.RepairService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repairJob")
public class RepairJobDescriptionControllers {

    private final RepairJobDescriptionService repairJobService;

    public RepairJobDescriptionControllers(RepairService repairService, JobService jobService, RepairJobDescriptionService repairJobService) {
        this.repairJobService = repairJobService;
    }

    @PostMapping("/{repairId}/{jobId}")
    public void addRepairJob(@PathVariable("repairId") Long repairId, @PathVariable("jobId") Long jobId) {
        repairJobService.addRepairJob(repairId, jobId);
    }



}
