package com.example.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Persona {
    private int id;
    private String nombre;
    private  String apellido;
    private int edad;
    private List<Sintoma> listaSintomas;
}
