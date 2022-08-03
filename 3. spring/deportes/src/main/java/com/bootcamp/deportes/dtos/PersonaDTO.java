package com.bootcamp.deportes.dtos;

import com.bootcamp.deportes.entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private List<String> deportes;
}
