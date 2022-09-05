package com.bootcamp.autos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;

    private String marca;

    @Column(name = "anio_fabricacion")
    private LocalDate anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;

    private String modelo;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;
}
