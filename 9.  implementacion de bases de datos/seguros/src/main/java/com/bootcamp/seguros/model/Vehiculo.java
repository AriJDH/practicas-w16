package com.bootcamp.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "año_fabricacion")
    private LocalDate añoFabricacion;
    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo",cascade = CascadeType.ALL)
    private Set<Siniestro> siniestros;

}
