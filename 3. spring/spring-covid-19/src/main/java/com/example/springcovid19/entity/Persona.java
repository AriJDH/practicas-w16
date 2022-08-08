package com.example.springcovid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;
}
