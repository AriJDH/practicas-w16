package com.meli.seguro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter@Setter
public class Siniestro {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idSiniestro;
    private Date fechaSiniestro;
    private Double perdidaEconomica;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    @JoinColumn(name="idVehiculo")
    private Vehiculo vehiculo;
}
