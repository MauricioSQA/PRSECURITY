package com.isil.demo.jwt.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="animales")
public class Animal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nombrecient;

}
