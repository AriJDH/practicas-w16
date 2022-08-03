package com.example.deportista.Entity;

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
    private Deporte deporte;

}
