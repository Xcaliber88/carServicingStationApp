package com.example.carservicingstation.Dtos;

import com.example.carservicingstation.Model.CarPart;

import java.util.Optional;

public class JobDto {

    private Long id;

    private String jobsName;

    private String jobOverview;

    private int labourHours;

    private double hourlyLabourCost;

    private CarPart part;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobsName() {
        return jobsName;
    }

    public void setJobsName(String jobsName) {
        this.jobsName = jobsName;
    }

    public String getJobOverview() {
        return jobOverview;
    }

    public void setJobOverview(String jobOverview) {
        this.jobOverview = jobOverview;
    }

    public int getLabourHours() {
        return labourHours;
    }

    public void setLabourHours(int labourHours) {
        this.labourHours = labourHours;
    }

    public double getHourlyLabourCost() {
        return hourlyLabourCost;
    }

    public void setHourlyLabourCost(double hourlyLabourCost) {
        this.hourlyLabourCost = hourlyLabourCost;
    }

    public CarPart getPart() {
        return part;
    }

    public void setPart(CarPart part) {
        this.part = part;
    }
}
