package com.vehiculos.seguro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "vehiculo_denunciado_id")
    private Vehiculo vehiculoDenunciado;
}
