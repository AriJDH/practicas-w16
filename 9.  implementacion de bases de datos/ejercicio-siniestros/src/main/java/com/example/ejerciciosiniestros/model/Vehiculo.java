package com.example.ejerciciosiniestros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private Integer cantidadRuedas;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private List<Siniestro> siniestro;*/
}
