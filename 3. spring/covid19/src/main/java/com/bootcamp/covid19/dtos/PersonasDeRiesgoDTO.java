package com.bootcamp.covid19.dtos;

import com.bootcamp.covid19.entities.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonasDeRiesgoDTO {

    private String nombre;
    private String apellido;


}
