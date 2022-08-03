package com.example.ejcovid19.services;

import com.example.ejcovid19.dtos.PersonaDto;
import com.example.ejcovid19.entities.Persona;
import com.example.ejcovid19.entities.Sintoma;

import java.util.List;

public class PersonaService {

    private List<PersonaDto> personas = List.of(
            new PersonaDto(new Persona(1, "ruben","bazan",20), new Sintoma(1, "tos", "baja")),
            new PersonaDto(new Persona(2, "liz","jerez",67), new Sintoma(1, "consquillas", "baja")),
            new PersonaDto(new Persona(3, "matias","costilla",61), new Sintoma(1, "fiebre", "Alta")),
            new PersonaDto(new Persona(4, "fer","bazan",70), new Sintoma(1, "fiebre", "Alta"))
            );

    public List<PersonaDto> getPersonasEnRiesgo() {
        SintomaService sintomaService = new SintomaService();
        var sintomas = sintomaService.getSintomas();

        var personasSintoma = personas.stream()
                .filter(persona ->{
                    var sintoma = sintomas.stream()
                            .filter(s -> s.getNombre().equalsIgnoreCase(persona.getSintoma().getNombre()))
                            .findFirst()
                            .orElse(null);
                    return sintoma != null;
                })
                .filter(persona -> persona.getPersona().getEdad() > 60)
                .collect(java.util.stream.Collectors.toList());

        return personasSintoma;
    }
}
