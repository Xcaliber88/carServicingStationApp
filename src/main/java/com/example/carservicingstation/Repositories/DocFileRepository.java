package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface DocFileRepository extends JpaRepository<FileDocument, Long> {

    FileDocument findByFileName(String filename);
}
