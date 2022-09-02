package com.bootcamp.ejerciciovehiculossiniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoMPMDto {
    private String patente;
    private String marca;
    private String modelo;
}
