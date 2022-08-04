package com.ejercicio.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private long codigo;
    private String nombre;
    private String nivelDeGravedad;
}
