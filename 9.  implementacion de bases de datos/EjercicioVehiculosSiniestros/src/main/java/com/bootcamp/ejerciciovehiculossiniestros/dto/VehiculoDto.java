package com.bootcamp.ejerciciovehiculossiniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehiculoDto {

    private String patente;
    private String marca;
    private String modelo;
    private Long anio;
    private Long ruedas;


}
