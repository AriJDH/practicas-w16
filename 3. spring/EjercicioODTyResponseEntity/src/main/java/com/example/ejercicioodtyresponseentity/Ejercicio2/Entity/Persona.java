package com.example.ejercicioodtyresponseentity.Ejercicio2.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    private int id=0;
    private String nombrePersona;
    private String apellidoPersona;
    private Integer edadPersona;
    ArrayList<Persona> personas = new ArrayList<Persona>();

    public Persona(int idPersona, String nombre, String apellido, Integer edad) {
    }
}
