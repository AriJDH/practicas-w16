package com.spring.personajes_star_wars.service;

import com.spring.personajes_star_wars.DTO.PersonajeDTO;
import com.spring.personajes_star_wars.entity.Personaje;
import com.spring.personajes_star_wars.repository.IPersonajesDAO;
import com.spring.personajes_star_wars.repository.PersonajesDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajesServiceImpl implements IPersonajesService {

    IPersonajesDAO iPersonajesDAO;

    public PersonajesServiceImpl(){
        iPersonajesDAO = new PersonajesDAOImpl();
    }

    @Override
    public List<PersonajeDTO> listarPersonajesxNombre(String name) {
        List<PersonajeDTO> listaTodos = iPersonajesDAO.getPersonajes();

        List<PersonajeDTO> listaFiltrados = listaTodos.stream().filter(person -> person.getName().contains(name)).collect(Collectors.toList());

        if(!listaFiltrados.isEmpty()) {
            return listaFiltrados;
        } else {
            PersonajeDTO nulo = new PersonajeDTO();
            listaFiltrados.add(nulo);
            return listaFiltrados;
        }

        int e = listaTodos.stream().reduce(0, (a, b) -> a + b.getHeight(), Integer::sum);
    }
}
