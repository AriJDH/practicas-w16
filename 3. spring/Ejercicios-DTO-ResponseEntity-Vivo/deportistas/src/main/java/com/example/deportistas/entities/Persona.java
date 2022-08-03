package com.example.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

}
