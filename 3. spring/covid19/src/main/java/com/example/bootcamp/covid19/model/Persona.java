package com.example.bootcamp.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persona {
    int id;
    String nombre;
    String apellido;
    int edad;
    List<Sintoma> sintomas;

}
