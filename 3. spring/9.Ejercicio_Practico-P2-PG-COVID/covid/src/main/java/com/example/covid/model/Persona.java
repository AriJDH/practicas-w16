package com.example.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;
}
