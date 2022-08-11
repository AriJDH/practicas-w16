package com.grodriguez.covid.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaRiesgoDTO {
    public String nombre;
    public String apellido;
    public String sintoma;
}
