package com.ejercicio.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private int edad;
    private List<String> sintomas = new ArrayList<>();
}
