package com.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private Integer codigo;
    private String nombre;
    private String nivelDeGravedad;
}
