package com.example.carservicingstation.Dtos;

import com.example.carservicingstation.Model.RepairJobDescription;

import java.util.Collection;

public class RepairDto {

    private Long id;

    private String repairName;

    private String repairDescription;




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


}
