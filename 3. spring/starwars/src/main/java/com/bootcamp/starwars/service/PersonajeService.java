package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.PersonajeDTO;
import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.repository.IRepository;
import com.bootcamp.starwars.repository.PersonajeRepository;
import com.bootcamp.starwars.utils.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IService<PersonajeDTO>{
    private final IRepository<Personaje> personajeRepository;

    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeDTO> getAll(){
        return personajeRepository.getAll().stream()
                .map(Util::parsePersonajeToPeronajeDTO)
                .collect(Collectors.toList());
    }

    public List<PersonajeDTO> getByName(String name){
        return personajeRepository.getByName(name).stream()
                .map(Util::parsePersonajeToPeronajeDTO)
                .collect(Collectors.toList());
    }
}
