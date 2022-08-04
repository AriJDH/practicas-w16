package com.example.ejercicio2.entitisDto;

import com.example.ejercicio2.entities.Sintomas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private String sintoma;
}
