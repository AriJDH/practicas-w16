package com.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Riesgo {

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    List<Sintoma> sintomaList;
}
