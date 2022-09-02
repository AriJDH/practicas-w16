package com.vehiculos.seguro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteModeloMarcaDTO {

    private String patente;
    private String marca;
    private String modelo;

}
