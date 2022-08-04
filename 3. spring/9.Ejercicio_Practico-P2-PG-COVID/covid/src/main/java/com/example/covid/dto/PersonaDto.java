package com.example.covid.dto;

import com.example.covid.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
    private String nombreSintoma;
    private String nivelGravedad;
}
