package com.bootcamp.empresaseguroshql.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniestro")
public class Siniestro {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private LocalDate fecha;
    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculoSiniestrado;
}
