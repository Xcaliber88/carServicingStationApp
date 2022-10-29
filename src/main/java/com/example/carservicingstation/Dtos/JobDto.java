package com.example.carservicingstation.Dtos;

import java.util.List;

public class JobDto {

    private Long id;

    private String jobsName;

    private String jobOverview;

    private int labourHours;

    private double hourlyLabourCost;

    private List<CarPartDto> carPartDtoList;


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

    public List<CarPartDto> getCarPartDtoList() {
        return carPartDtoList;
    }

    public void setCarPartDtoList(List<CarPartDto> carPartDtoList) {
        this.carPartDtoList = carPartDtoList;
    }
}
