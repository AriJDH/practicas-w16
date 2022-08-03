package com.example.ejdeportistas.services;

import com.example.ejdeportistas.dtos.DeporteDto;
import com.example.ejdeportistas.dtos.PersonaDto;
import com.example.ejdeportistas.entities.Deporte;
import com.example.ejdeportistas.entities.Persona;
import lombok.Data;

import java.util.List;

@Data
public class PersonaService {

    private List<PersonaDto> personas = List.of(
            new PersonaDto(new Persona("ruben", "bazan",20, new Deporte("futbol", "Principiante"))),
            new PersonaDto(new Persona("ruben", "bazan",20, new Deporte("voley", "Principiante"))),
            new PersonaDto(new Persona("ruben", "bazan",20, new Deporte("tenis", "Principiante")))
    );

    public List<PersonaDto> getPersonasDeporte(String deporte) {
        var personasDeporte = personas.stream()
                .filter(persona -> persona.getPersona().getDeporte().getNombre().equals(deporte))
                .collect(java.util.stream.Collectors.toList());

        return personasDeporte;
    }
}
