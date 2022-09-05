package com.bootcamp.seguro.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado", fetch = FetchType.LAZY)
    private List<Siniestro> siniestros;


}
