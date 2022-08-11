package com.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
