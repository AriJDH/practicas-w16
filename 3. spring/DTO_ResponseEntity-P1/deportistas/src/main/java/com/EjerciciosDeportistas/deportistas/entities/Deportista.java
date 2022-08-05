package com.EjerciciosDeportistas.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Deportista {

    private Persona deportista;
    private Deporte deportePractica;
}
