package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.JobDescription;
import com.example.carservicingstation.Model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAllRepairByRepairNameEqualsIgnoreCase(String repairName);
}
