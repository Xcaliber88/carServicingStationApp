package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobDescription, Long> {

    List<JobDescription>findAllJobsByJobsNameEqualsIgnoreCase(String jobsName);
}
