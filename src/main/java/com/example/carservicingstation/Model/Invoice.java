package com.example.carservicingstation.Model;

import javax.persistence.*;

@Entity
@Table(name="Invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
