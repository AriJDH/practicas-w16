package com.example.ejerciciosiniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
}
