package com.example.deportista.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String deporte;


}
