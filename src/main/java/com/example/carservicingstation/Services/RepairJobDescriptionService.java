package com.example.carservicingstation.Services;

import com.example.carservicingstation.Dtos.JobDto;
import com.example.carservicingstation.Model.JobDescription;
import com.example.carservicingstation.Model.Repair;
import com.example.carservicingstation.Model.RepairJobDescription;
import com.example.carservicingstation.Model.RepairJobDescriptionKey;
import com.example.carservicingstation.Repositories.JobDescriptionRepository;
import com.example.carservicingstation.Repositories.RepairJobDescriptionRepository;
import com.example.carservicingstation.Repositories.RepairRepository;
import com.example.carservicingstation.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class RepairJobDescriptionService {

    private final RepairRepository repairRepos;

    private final JobDescriptionRepository jobRepos;

    private final RepairJobDescriptionRepository repairJobRepos;

    public RepairJobDescriptionService(RepairRepository repairRepos, JobDescriptionRepository jobRepos, RepairJobDescriptionRepository repairJobRepos) {
        this.repairRepos = repairRepos;
        this.jobRepos = jobRepos;
        this.repairJobRepos = repairJobRepos;
    }

    public Collection<JobDto> getRepairJobDescriptionByRepairId(Long repairId) {
        Collection<JobDto> dtos = new HashSet<>();
        Collection<RepairJobDescription> repairJobDescriptions = repairJobRepos.findAllByRepairId(repairId);
        for(RepairJobDescription repairJobDescription: repairJobDescriptions){
            JobDescription job = repairJobDescription.getJob();
            JobDto dto = new JobDto();

            dto.setId(job.getId());;
            dto.setJobsName(job.getJobsName());
            dto.setJobOverview(job.getJobOverview());
            dto.setLabourHours(job.getLabourHours());
            dto.setHourlyLabourCost(job.getHourlyLabourCost());
            dto.setPart(job.getPart());

            dtos.add(dto);
        }
        return dtos;
    }

    public Collection<JobDto> getRepairJobDescriptionByRepairName(String repairName) {
        Collection<JobDto> dtos = new HashSet<>();
        Collection<RepairJobDescription> repairJobDescriptions = repairJobRepos.findRepairJobDescriptionByRepair_RepairName(repairName);
        for(RepairJobDescription repairJobDescription: repairJobDescriptions){
            JobDescription job = repairJobDescription.getJob();
            JobDto dto = new JobDto();

            dto.setId(job.getId());;
            dto.setJobsName(job.getJobsName());
            dto.setJobOverview(job.getJobOverview());
            dto.setLabourHours(job.getLabourHours());
            dto.setHourlyLabourCost(job.getHourlyLabourCost());
            dto.setPart(job.getPart());

            dtos.add(dto);
        }
        return dtos;
    }

    public RepairJobDescriptionKey addRepairJob(Long repairId, Long jobId) {
        RepairJobDescription repairJobDescription = new RepairJobDescription();
        if (!repairRepos.existsById(repairId)) {throw new RecordNotFoundException();}
        Repair repair = repairRepos.findById(repairId).orElse(null);
        if (!jobRepos.existsById(jobId)) {throw new RecordNotFoundException();}
        JobDescription job = jobRepos.findById(jobId).orElse(null);
        repairJobDescription.setRepair(repair);
        repairJobDescription.setJob(job);
        RepairJobDescriptionKey id = new RepairJobDescriptionKey(repairId, jobId);
        repairJobDescription.setId(id);
        repairJobRepos.save(repairJobDescription);
        return id;
    }


}
