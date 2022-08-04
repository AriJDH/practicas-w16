package com.example.ejercicio2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Data
@Builder
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintomas sintoma;
}
