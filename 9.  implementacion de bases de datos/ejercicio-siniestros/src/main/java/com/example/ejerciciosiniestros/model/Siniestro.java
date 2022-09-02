package com.example.ejerciciosiniestros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    public Siniestro(LocalDate fechaSiniestro, Double perdidaEconomica, Vehiculo vehiculo) {
        this.fechaSiniestro = fechaSiniestro;
        this.perdidaEconomica = perdidaEconomica;
        this.vehiculo = vehiculo;
    }
}
