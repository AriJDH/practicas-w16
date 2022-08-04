package com.bootcamp.deportistas.dtos;

import com.bootcamp.deportistas.entities.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PersonaDto {

    private String nombre;
    private String apellido;
    private String nombreDeportePracticado;

}
