package com.grodriguez.covid.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
