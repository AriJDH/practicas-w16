package com.bootcamp.ejerciciovehiculossiniestros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdida;
    @ManyToOne
    private Vehiculo vehiculo;

}
