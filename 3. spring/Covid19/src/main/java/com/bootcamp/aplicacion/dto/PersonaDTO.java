package com.bootcamp.aplicacion.dto;

import com.bootcamp.aplicacion.entities.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;
}
