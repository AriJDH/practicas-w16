package com.bootcamp.automoviles.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "siniestros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Siniestros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    @ManyToOne
    private Vehiculos vehiculos;

}
