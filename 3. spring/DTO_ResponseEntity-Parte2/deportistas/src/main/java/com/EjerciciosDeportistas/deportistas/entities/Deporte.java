package com.EjerciciosDeportistas.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Deporte {
    private String nombre;
    private int nivel;
}
