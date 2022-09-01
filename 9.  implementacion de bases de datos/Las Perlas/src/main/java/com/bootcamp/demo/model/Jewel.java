package com.bootcamp.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "jewel")
public class Jewel {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long nro_identificatorio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "material")
    private String material;

    @Column(name = "peso")
    private double peso;

    @Column(name = "particularidad")
    private String particularidad;

    @Column(name = "posee_piedra")
    private boolean posee_piedra;

    @Column(name = "ventaONo")
    private boolean ventaONo;


}

