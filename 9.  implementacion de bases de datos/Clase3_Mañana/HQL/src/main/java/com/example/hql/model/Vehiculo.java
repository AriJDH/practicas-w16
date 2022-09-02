package com.example.hql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String patente;
    private String marca;
    private String modelo;
    private String anio_fabricacion;
    private int cantidad_ruedas;
    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;
}
