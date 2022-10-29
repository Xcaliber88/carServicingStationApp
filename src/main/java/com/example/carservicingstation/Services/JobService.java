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

@Service
public class JobService {

    private final JobRepository jobRepos;
    private final CarPartRepository carPartRepos;

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
        List<CarPart> partList = new ArrayList<>();

        for (CarPart part : partList) {
            CarPartDto dtos = CarPartService.transferToCarPartDto(part);
            List<CarPart>.add(dtos);

            CarPartDto dtos=
            dto.setCarPartDtoList(CarPartService.transferToCarPartDto(part));
            partList.add(part);
        }

            dto.setId(job.getId());
            dto.setJobsName(job.getJobsName());
            dto.setJobOverview(job.getJobOverview());
            dto.setLabourHours(job.getLabourHours());
            dto.setHourlyLabourCost(job.getHourlyLabourCost());

        return dto;
    }

    public JobDescription toJob (JobDto jobDto){

        JobDescription job = new JobDescription();

        job.setId(jobDto.getId());
        job.setJobsName(jobDto.getJobsName());
        job.setJobOverview(jobDto.getJobOverview());
        job.setLabourHours(jobDto.getLabourHours());
        job.setHourlyLabourCost(jobDto.getHourlyLabourCost());

        return job;
    }
}
