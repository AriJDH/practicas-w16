package com.bootcamp.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "siniestro")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fecha_del_siniestro")
    private LocalDate fechaDelSiniestro;

    @Column(name = "perdida_economica")
    private Integer perdidaEconomica;

    //Id del vehículo denunciado
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;
}
