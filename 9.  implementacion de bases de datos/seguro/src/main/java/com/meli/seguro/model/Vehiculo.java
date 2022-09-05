package com.meli.seguro.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter@Getter
@Table(name="vehiculo")
public class Vehiculo {


    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    private Integer año;
    private Integer cantidadRuedas;


    public Vehiculo(Integer idVehiculo, String patente, String marca, String modelo, Integer año, Integer cantidadRuedas) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.cantidadRuedas = cantidadRuedas;
    }

    public Vehiculo() {

    }

    @OneToMany(mappedBy = "siniestro")
    private Set<Siniestro> siniestros;
}
