package com.EjerciciosDeportistas.deportistas.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;

}
