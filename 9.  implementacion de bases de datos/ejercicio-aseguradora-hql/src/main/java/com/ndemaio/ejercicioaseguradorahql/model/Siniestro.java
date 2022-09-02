package com.ndemaio.ejercicioaseguradorahql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn (name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;


}
