package com.grupodeportista.personasdeportes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre, apellido;
    private int edad;
    private Deporte deporte;



}
