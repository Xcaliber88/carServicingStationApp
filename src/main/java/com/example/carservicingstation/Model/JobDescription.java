package com.example.carservicingstation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="job_description")
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobsName;

    private String jobOverview;

    private int labourHours;

    private double hourlyLabourCost;

    @OneToOne
    private CarPart part;

    @OneToMany(mappedBy = "repair")
    @JsonIgnore
    private List<RepairJobDescription> repairJobDescriptions;


    public JobDescription(){}

    public JobDescription(String jobsName, String jobOverview, int labourHours, double hourlyLabourCost) {
        this.jobsName = jobsName;
        this.jobOverview = jobOverview;
        this.labourHours = labourHours;
        this.hourlyLabourCost = hourlyLabourCost;
    }

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

    public String getJobOverview() { return jobOverview; }

    public void setJobOverview(String jobOverview) {
        this.jobOverview = jobOverview;
    }

    public int getLabourHours() { return labourHours;}

    public void setLabourHours(int labourHours) {this.labourHours = labourHours;}

    public double getHourlyLabourCost() { return hourlyLabourCost;}

    public void setHourlyLabourCost(double hourlyLabourCost) { this.hourlyLabourCost = hourlyLabourCost;}

    public CarPart getPart() {
        return part;
    }

    public void setPart(CarPart part) {
        this.part = part;
    }
}
