package com.example.carservicingstation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "uploads")
public class FileDocument {

    @Id
    @GeneratedValue
    private Long id;

    private String fileName;

    @Lob
    private byte[] docFile;

    @OneToOne(mappedBy = "fileDocument")
    @JsonIgnore
    private CarPart carPart;




    public String getFileName() {
        return fileName;
    }

    public byte[] getDocFile() {
        return docFile;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDocFile(byte[] docFile) {
        this.docFile = docFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarPart getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPart carPart) {
        this.carPart = carPart;
    }
}
