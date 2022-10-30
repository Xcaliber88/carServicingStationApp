package com.example.carservicingstation.Services;

import com.example.carservicingstation.Dtos.CarPartDto;
import com.example.carservicingstation.Dtos.JobDto;
import com.example.carservicingstation.Model.CarPart;
import com.example.carservicingstation.Model.JobDescription;
import com.example.carservicingstation.Repositories.CarPartRepository;
import com.example.carservicingstation.Repositories.JobRepository;
import com.example.carservicingstation.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepos;
    private static  CarPartRepository carPartRepos;

    public JobService(JobRepository jobRepos, CarPartRepository carPartRepos) {
        this.jobRepos = jobRepos;
        this.carPartRepos = carPartRepos;
    }

    public List<JobDto> getAllJobs(){

        List<JobDescription> jobList = jobRepos.findAll();
        List<JobDto> jobDtoList = new ArrayList<>();

        for(JobDescription job: jobList){
            JobDto dto = transferToJobDto(job);
            jobDtoList.add(dto);
        }

        return jobDtoList;
    }
    public List<JobDto> getAllJobsByJobName(String jobsName){

        List<JobDescription> jobList = jobRepos.findAllJobsByJobsNameEqualsIgnoreCase(jobsName);
        List<JobDto> jobDtoList = new ArrayList<>();

        for(JobDescription job: jobList){
            JobDto dto = transferToJobDto(job);
            jobDtoList.add(dto);
        }
        return jobDtoList;
    }

    public JobDto addJob(JobDto jobDto){

        JobDescription savedJob = toJob(jobDto);
        this.jobRepos.save(savedJob);

        return transferToJobDto(savedJob);
    }
    public JobDto updateJob(Long id, JobDto jobDto){

        if(jobRepos.findById(id).isPresent()){
            JobDescription job = jobRepos.findById(id).get();

            // CarPart updateCarPart= toPart(partDto);
            //updateCarPart.setId(carPart.getId());

            if(!(jobDto.getJobsName()==null)){job.setJobsName(jobDto.getJobsName());}
            if(!(jobDto.getJobOverview()==null)){job.setJobOverview(jobDto.getJobOverview());}
            if(!(jobDto.getLabourHours()<=0)){job.setLabourHours(jobDto.getLabourHours());}
            if(!(jobDto.getHourlyLabourCost()<=0)){job.setHourlyLabourCost(jobDto.getHourlyLabourCost());}

            jobRepos.save(job);

            return transferToJobDto(job);

        }else {
            throw new RecordNotFoundException("Auto onderdeel niet gevonden");
        }
    }
    public void deleteJob(@RequestBody Long id){

        jobRepos.deleteById(id);
    }


    public JobDto transferToJobDto(JobDescription job) {


        JobDto dto = new JobDto();

//        List<CarPart> partList = carPartRepos.findAllById(job.getId());
//        List<CarPartDto> carPartDtoList = new ArrayList<>();
//
//        for (CarPart part : partList) {
//            CarPartDto dtos = CarPartService.transferToCarPartDto(part);
//            carPartDtoList.add(dtos);
//
//            dto.setCarPartDtoList(carPartDtoList);
//        }

            dto.setId(job.getId());
            dto.setJobsName(job.getJobsName());
            dto.setJobOverview(job.getJobOverview());
            dto.setLabourHours(job.getLabourHours());
            dto.setHourlyLabourCost(job.getHourlyLabourCost());
            dto.setPart(job.getPart());

        return dto;
    }

    public JobDescription toJob (JobDto jobDto){

        JobDescription job = new JobDescription();
//        List<CarPart> partList = new ArrayList<>();
//        List<CarPartDto> carPartDtoList = new ArrayList<>();
//
//        for (CarPartDto partDto : carPartDtoList) {
//            CarPart part = CarPartService.toPart(partDto);
//           partList.add(part);
//
//            job.setParts(partList);
//        }

        job.setId(jobDto.getId());
        job.setJobsName(jobDto.getJobsName());
        job.setJobOverview(jobDto.getJobOverview());
        job.setLabourHours(jobDto.getLabourHours());
        job.setHourlyLabourCost(jobDto.getHourlyLabourCost());
        job.setPart(jobDto.getPart());

        return job;
    }

    public JobDto assignCarPartToJob(Long jobId, Long partId){
        Optional<CarPart> optionalCarPart = carPartRepos.findById(partId);
        Optional<JobDescription> optionalJob = jobRepos.findById(jobId);

        if (optionalJob.isPresent() && optionalCarPart.isPresent()){
            JobDescription job = optionalJob.get();
            CarPart part = optionalCarPart.get();
            job.setPart(part);
            jobRepos.save(job);
            return transferToJobDto(job);
        } else {
            throw new RuntimeException("Job description or car part does not exist");
        }
    }
}
