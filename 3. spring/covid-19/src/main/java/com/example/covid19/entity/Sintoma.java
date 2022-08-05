package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {

    private String codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

}
