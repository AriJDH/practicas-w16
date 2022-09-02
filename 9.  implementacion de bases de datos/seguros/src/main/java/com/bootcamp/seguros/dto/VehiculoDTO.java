package com.bootcamp.seguros.dto;

import com.bootcamp.seguros.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehiculoDTO {

    private String patente;
    private String marca;
    private String modelo;
    private LocalDate añoFabricacion;
    private int cantidadRuedas;
    private Set<Siniestro> siniestros;

}
