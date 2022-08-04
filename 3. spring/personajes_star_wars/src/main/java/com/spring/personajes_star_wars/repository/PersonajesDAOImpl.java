package com.spring.personajes_star_wars.repository;

import com.spring.personajes_star_wars.DTO.PersonajeDTO;
import com.spring.personajes_star_wars.entity.Personaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonajesDAOImpl implements IPersonajesDAO{

    @Override
    public List<PersonajeDTO> getPersonajes() {

        PersonajeDTO per1 = new PersonajeDTO("Anakin Skywalker", 188, 84, "Male", "Tatooine", "Human");
        PersonajeDTO per2 = new PersonajeDTO("Luke Skywalker", 172, 77, "Male", "Tatooine", "Human");
        PersonajeDTO per3 = new PersonajeDTO("Darth Maul", 175, 80, "Male", "Dathomir", "Zabrak");
        PersonajeDTO per4 = new PersonajeDTO("Darth Vader", 202, 136, "Male", "Tatooine", "Human");

        List<PersonajeDTO> list = new ArrayList<>(Arrays.asList(per1, per2, per3, per4));

        return list;
    }

}
