package com.EjerciciosDeportistas.deportistas.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DeporteDTO {
    private String nombre;
    private int nivel;
}
