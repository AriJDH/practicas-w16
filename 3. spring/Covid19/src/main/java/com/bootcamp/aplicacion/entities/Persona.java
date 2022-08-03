package com.bootcamp.aplicacion.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;
}
