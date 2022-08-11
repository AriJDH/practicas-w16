package com.grodriguez.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
