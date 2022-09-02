package com.bootcamp.empresaseguroshql.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
}
