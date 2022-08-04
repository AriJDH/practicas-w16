package com.bootcamp.covid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SintomasDTO {
    private double codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
