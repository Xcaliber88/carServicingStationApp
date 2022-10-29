package com.example.carservicingstation.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

}
