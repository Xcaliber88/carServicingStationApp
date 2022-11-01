package com.example.carservicingstation.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RepairJobDescriptionKey implements Serializable {

    @Column(name = "repair_id")
    private Long repairId;

    @Column(name = "job_id")
    private Long jobId;

    public RepairJobDescriptionKey(){}

    public RepairJobDescriptionKey(Long repairId, Long jobId) {
        this.repairId = repairId;
        this.jobId = jobId;
    }


    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        RepairJobDescriptionKey that = (RepairJobDescriptionKey) o;
        return repairId.equals(that.repairId)&& jobId.equals(that.jobId);
    }

    @Override
    public int hashCode() {return Objects.hash(repairId, jobId);}

}
