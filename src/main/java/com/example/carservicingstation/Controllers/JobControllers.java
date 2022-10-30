package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Dtos.CarPartDto;
import com.example.carservicingstation.Dtos.JobDto;
import com.example.carservicingstation.Services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class JobControllers {

    private final JobService jobService;

    public JobControllers(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs/jobsName")
    public ResponseEntity<List<JobDto>> getAllJobs(@RequestParam(value = "jobsName", required = false)Optional<String>jobsName){

        List<JobDto> dtos;

        if(!jobsName.isPresent()){
            dtos = jobService.getAllJobs();
        }else {
            dtos = jobService.getAllJobsByJobName(jobsName.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/jobs")
    public ResponseEntity<Object> addJob(@RequestBody JobDto jobDto) {
        JobDto dto= jobService.addJob(jobDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Object> updateJob(@PathVariable Long id, @RequestBody JobDto updateJobDto){
        JobDto dto = jobService.updateJob(id, updateJobDto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/jobs/{id}")
    public  ResponseEntity<Object> deleteJob(@PathVariable Long id){
        jobService.deleteJob(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jobs/{jobId}/parts/{partId}")
    public ResponseEntity<Object> assignCarPartToJob(@PathVariable Long jobId, @PathVariable Long partId){

        JobDto jobDto = jobService.assignCarPartToJob(jobId,partId);
        return  ResponseEntity.ok().body(jobDto);
    }
}
