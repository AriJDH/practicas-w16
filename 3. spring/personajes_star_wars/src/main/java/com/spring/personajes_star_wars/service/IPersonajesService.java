package com.spring.personajes_star_wars.service;

import com.spring.personajes_star_wars.DTO.PersonajeDTO;

import java.util.List;

public interface IPersonajesService {
    List<PersonajeDTO> listarPersonajesxNombre(String name);
}
