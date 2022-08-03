package com.example.deportista.services;

import com.example.deportista.dtos.PersonaDto;

import com.example.deportista.entities.Deporte;
import com.example.deportista.entities.Persona;
import lombok.Data;
import java.util.List;

@Data
public class PersonaService {


    private List<PersonaDto> listaPersonas = List.of(
            new PersonaDto(new Persona("ruben", "bazan",20, new Deporte("Futbol", "Principiante"))),
            new PersonaDto(new Persona("Sebastian", "Riquelme",20, new Deporte("Voleiball", "Principiante"))),
            new PersonaDto(new Persona("Jose", "Montecino",20, new Deporte("Tenis", "Principiante")))
    );


}
