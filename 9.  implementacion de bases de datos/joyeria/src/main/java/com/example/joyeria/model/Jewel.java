package com.example.joyeria.model;


// nro_identificatorio, nombre, material (oro, plata, etc), peso (en gramos), particularidad, posee_piedra, ventaONo.

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String material;
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false)
    private String particularity;
    @Column(nullable = false)
    private Boolean hasStone;
    @Column(nullable = false)
    private Boolean isSold = false;
}
