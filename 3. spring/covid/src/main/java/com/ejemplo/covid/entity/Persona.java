package com.ejemplo.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

}
