package com.bootcamp.deportes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> deportesAplicados;
}
