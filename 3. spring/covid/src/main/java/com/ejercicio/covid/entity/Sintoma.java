package com.ejercicio.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {

    private long codigo;
    private String nombre;
    private String nivelDeGravedad;
}
