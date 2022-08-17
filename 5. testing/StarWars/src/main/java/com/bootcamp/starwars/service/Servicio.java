package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.repository.Personajes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicio {

    private final Personajes personajes;

    public Servicio(Personajes personajes) {
        this.personajes = personajes;
    }

    public List<PersonajeDTO> listarPersonajes(String name){
        return personajes.encontrarPersonajes(name);
    }


}
