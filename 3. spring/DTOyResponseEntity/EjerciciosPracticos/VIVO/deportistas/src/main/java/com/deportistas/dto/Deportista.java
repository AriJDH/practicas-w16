package com.deportistas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deportista extends Persona {

    private Deporte deporte;

    public Deportista(String nombre, String apellido, int edad, Deporte deporte) {
        super(nombre, apellido, edad);
        this.deporte = deporte;
    }
    
}
