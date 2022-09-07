package com.example.Aseguradora.Autos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoPatenteMarcaModeloDto {

    private String patente;
    private String marca;
    private String modelo;
}
