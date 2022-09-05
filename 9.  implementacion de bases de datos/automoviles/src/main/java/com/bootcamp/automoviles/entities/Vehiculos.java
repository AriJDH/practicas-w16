package com.bootcamp.automoviles.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "vehiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "patente", unique = true)
    private String patente;
    private String marca;
    private LocalDate anioFabricacion;
    private int cantidadRuedas;
    @OneToMany(mappedBy = "vehiculos", cascade = CascadeType.ALL)
    private Set<Siniestros> siniestros;

    public Vehiculos(Long id) {
        this.id = id;
    }

    public Vehiculos(Long id, String patente) {
        this.id = id;
        this.patente = patente;
    }
}
