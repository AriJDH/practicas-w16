package com.example.Aseguradora.Autos.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="siniestros")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_siniestro")
    private Integer idSiniestro;

    @Column(name = "fecha_siniestro")
    private Date fechaSiniestro;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Vehiculo vehiculo;


}
