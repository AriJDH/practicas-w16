package com.ejercicio.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas = new ArrayList<>();

}
