package com.spring.personajes_star_wars.repository;

import com.spring.personajes_star_wars.DTO.PersonajeDTO;
import com.spring.personajes_star_wars.entity.Personaje;

import java.util.List;

public interface IPersonajesDAO {
    List<PersonajeDTO> getPersonajes();
}
