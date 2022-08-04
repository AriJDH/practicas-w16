package com.bootcamp.covid19.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {

    private long codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
