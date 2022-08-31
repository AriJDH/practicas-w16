package com.implementacionbd.Joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean poseePriedra;
    private boolean ventaONo;
}
