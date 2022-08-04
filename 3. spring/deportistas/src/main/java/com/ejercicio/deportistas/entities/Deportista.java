package com.ejercicio.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deportista {

    private Persona persona;
    private Deporte deporte;
}
