package com.bootcamp.ejerciciovehiculossiniestros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="vehiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Long anio;
    private Long ruedas;

}
