package com.example.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    private String patent;
    @Column(nullable = false, length = 50)
    private String brand;
    @Column(nullable = false, length = 50)
    private String model;
    @Column(nullable = false)
    private Integer yearOfProduction;
    @Column(nullable = false)
    private Short amountOfWheels;
    @OneToMany(mappedBy = "vehicle")
    private Set<Sinister> sinisters;
}
