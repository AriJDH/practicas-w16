package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;

}
