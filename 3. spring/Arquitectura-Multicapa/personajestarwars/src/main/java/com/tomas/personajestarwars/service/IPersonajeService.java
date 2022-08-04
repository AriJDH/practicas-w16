package com.tomas.personajestarwars.service;

import com.tomas.personajestarwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {

    List<PersonajeDto> listarPersonaje(String nombre);

}
