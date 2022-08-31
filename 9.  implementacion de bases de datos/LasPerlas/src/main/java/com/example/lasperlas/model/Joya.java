package com.example.lasperlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long nroIdentificatorio;
    String nombre;
    String material;
    double peso;
    String particularidad;
    boolean poseePiedra;
    boolean venta;
}
