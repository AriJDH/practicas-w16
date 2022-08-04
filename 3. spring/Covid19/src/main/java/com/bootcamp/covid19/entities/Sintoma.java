package com.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;
}
