package com.meli.seguroshql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String patent;

    private String brand;

    private String model;

    private Integer yearProduction;

    private Integer numberWheels;

    @OneToMany(mappedBy = "vehicle")
    private Set<Sinister> sinisters;
}
