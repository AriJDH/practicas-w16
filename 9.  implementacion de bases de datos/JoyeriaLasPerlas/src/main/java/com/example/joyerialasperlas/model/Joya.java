package com.example.joyerialasperlas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long nro_identificatorio;
    private String nombre;
    private String material;
    private double peso ;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
