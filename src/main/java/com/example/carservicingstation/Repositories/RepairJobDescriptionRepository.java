package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.JobDescription;
import com.example.carservicingstation.Model.RepairJobDescription;
import com.example.carservicingstation.Model.RepairJobDescriptionKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RepairJobDescriptionRepository extends JpaRepository<RepairJobDescription, RepairJobDescriptionKey> {

        Collection<RepairJobDescription> findAllByRepairId(Long repairId);

        Collection<RepairJobDescription> findAllByJobId(Long jobId);

        Collection<RepairJobDescription> findRepairJobDescriptionByRepair_RepairName(String repairName);
}