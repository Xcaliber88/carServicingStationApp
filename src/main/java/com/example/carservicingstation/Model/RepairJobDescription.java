package com.example.carservicingstation.Model;


import javax.persistence.*;

@Entity
@Table(name = "repair_job_description")
public class RepairJobDescription {

    @EmbeddedId
    private RepairJobDescriptionKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("repairId")
    @JoinColumn(name = "repair_id")
    private Repair repair;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    private JobDescription job;


    public RepairJobDescriptionKey getId() {
        return id;
    }

    public void setId(RepairJobDescriptionKey id) {
        this.id = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public JobDescription getJob() {
        return job;
    }

    public void setJob(JobDescription job) {
        this.job = job;
    }
}
