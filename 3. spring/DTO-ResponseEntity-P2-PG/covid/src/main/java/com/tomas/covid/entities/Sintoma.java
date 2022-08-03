package com.tomas.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {

    private Long codigo;
    private String Nombre;
    private String nivelGravedad;

}
