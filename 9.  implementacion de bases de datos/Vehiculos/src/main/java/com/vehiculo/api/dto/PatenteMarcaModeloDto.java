package com.vehiculo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloDto {
    private String marca;
    private String patente;
    private String modelo;
}
