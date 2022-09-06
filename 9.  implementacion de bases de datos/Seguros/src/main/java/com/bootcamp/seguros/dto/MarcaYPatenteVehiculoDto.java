package com.bootcamp.seguros.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MarcaYPatenteVehiculoDto {
    private String marca;
    private String patente;
}
