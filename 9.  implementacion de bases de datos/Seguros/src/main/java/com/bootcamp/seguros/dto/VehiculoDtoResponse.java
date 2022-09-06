package com.bootcamp.seguros.dto;

import com.bootcamp.seguros.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDtoResponse {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private int cantidadRuedas;
    private List<Siniestro> siniestros;
}
