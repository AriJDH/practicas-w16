package com.bootcamp.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculos_id",nullable = false)
    private Vehiculo vehiculo;
}
