package com.bootcamp.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
}
