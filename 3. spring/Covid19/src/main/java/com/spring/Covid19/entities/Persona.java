package com.spring.Covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> listaDeSintomas;
}
