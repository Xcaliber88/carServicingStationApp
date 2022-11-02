package com.example.carservicingstation.Model;

import com.example.carservicingstation.Dtos.JobDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String repairName;

    private String repairDescription;

    @OneToMany(mappedBy = "repair")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<RepairJobDescription> repairJobDescriptions;

    public Repair() {}

    public Repair(Long id, String repairName, String repairDescription) {
        this.id = id;
        this.repairName = repairName;
        this.repairDescription = repairDescription;
    }


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
