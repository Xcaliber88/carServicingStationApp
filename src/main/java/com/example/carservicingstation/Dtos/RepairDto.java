package com.example.carservicingstation.Dtos;

import com.example.carservicingstation.Model.JobDescription;
import com.example.carservicingstation.Model.RepairJobDescription;

import java.util.Collection;
import java.util.List;

public class RepairDto {

    private Long id;

    private String repairName;

    private String repairDescription;

    private Collection<RepairJobDescription> repairJobDescriptions;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Collection<RepairJobDescription> getRepairJobDescriptions() {
        return repairJobDescriptions;
    }

    public void setRepairJobDescriptions(Collection<RepairJobDescription> repairJobDescriptions) {
        this.repairJobDescriptions = repairJobDescriptions;
    }
}
