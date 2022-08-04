package com.meli.startwars.service;

import com.meli.startwars.dto.PersonajeDTO;
import com.meli.startwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    @Autowired
    PersonajeRepository personajesrepository;

    public List<PersonajeDTO> mostrarPersonaje(String nombre){

        List<PersonajeDTO> personajesdto = new ArrayList<>();

        personajesrepository.getPersonajesdto()
                .stream()
                .filter(x -> x.getName().toUpperCase().contains(nombre.toUpperCase())).collect(Collectors.toList())
                .forEach(x -> {PersonajeDTO nuevopersonaje
                        = new PersonajeDTO(x.getName(),x.getHeight(),x.getMass(),x.getGender(),x.getHomeWorld(),x.getSpecies());
                personajesdto.add(nuevopersonaje);
                });

        return personajesdto;

    }


}
