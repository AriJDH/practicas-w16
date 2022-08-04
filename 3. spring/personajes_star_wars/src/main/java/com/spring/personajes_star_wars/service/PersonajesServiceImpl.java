package com.spring.personajes_star_wars.service;

import com.spring.personajes_star_wars.DTO.PersonajeDTO;
import com.spring.personajes_star_wars.entity.Personaje;
import com.spring.personajes_star_wars.repository.IPersonajesDAO;
import com.spring.personajes_star_wars.repository.PersonajesDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajesServiceImpl implements IPersonajesService {

    @Autowired
    IPersonajesDAO iPersonajesDAO;

    @Override
    public List<PersonajeDTO> listarPersonajesxNombre(String name) {
        List<Personaje> listaFiltrados = iPersonajesDAO.findAllByNameContains(name);

        List<PersonajeDTO> listaDtos = new ArrayList<>();

        for(Personaje personaje : listaFiltrados){
            listaDtos.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeWorld(), personaje.getSpecies()));
        }

        if(!listaDtos.isEmpty()){
            return listaDtos;
        } else {
            PersonajeDTO nulo = new PersonajeDTO();
            listaDtos.add(nulo);
            return listaDtos;
        }
    }
}
