package com.bootcamp.deportistas.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}
