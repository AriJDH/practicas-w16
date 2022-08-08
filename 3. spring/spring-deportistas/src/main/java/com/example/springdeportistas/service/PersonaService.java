package com.example.springdeportistas.service;

import com.example.springdeportistas.dto.PersonaDto;
import com.example.springdeportistas.entity.Deporte;
import com.example.springdeportistas.entity.Persona;
import lombok.Data;

import java.util.List;

@Data
public class PersonaService {

    private List<PersonaDto> personas = List.of(
            new PersonaDto(new Persona("ruben", "bazan",20, new Deporte("futbol", "Principiante"))),
            new PersonaDto(new Persona("gonzalo", "di pierro",29, new Deporte("voley", "Principiante"))),
            new PersonaDto(new Persona("juan", "perez",25, new Deporte("tenis", "Avanzado")))
    );

    public List<PersonaDto> getPersonasDeporte(String deporte) {
        var personasDeporte = personas.stream()
                                                        .filter(persona -> persona.getPersona().getDeporte().getNombre().equals(deporte))
                                                        .collect(java.util.stream.Collectors.toList());

        return personasDeporte;
    }
}
