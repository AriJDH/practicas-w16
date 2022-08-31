package com.example.joyerialp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Getter
@Setter
public class Jewerly {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificador;

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

}
