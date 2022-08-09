package com.personajes.starwars.service;

import com.personajes.starwars.dto.PersonajeDTO;
import com.personajes.starwars.entity.Personaje;
import com.personajes.starwars.repository.StarWarsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService {
    @Autowired
    StarWarsRepositoryImpl starWarsRepositoryImpl;

    public void saveAll(List<PersonajeDTO> personajesDTO) {
        starWarsRepositoryImpl.saveAll(fromPersonajeDtoToPersonaje(personajesDTO));
    }

    public List<PersonajeDTO> findAll() {
        List<PersonajeDTO> personajesDTO = fromPersonajeToPersonajeDto(starWarsRepositoryImpl.findAll());
        return personajesDTO;
    }

    public List<PersonajeDTO> findByAllByName(String name) {
        List<PersonajeDTO> personajesDTO = fromPersonajeToPersonajeDto(starWarsRepositoryImpl.findAllByName(name));
        return personajesDTO.stream().filter(per -> per.getName().toLowerCase().startsWith(name.toLowerCase())).collect(Collectors.toList());
    }

    private List<Personaje> fromPersonajeDtoToPersonaje(List<PersonajeDTO> personajesDTO) {
        List<Personaje> personajes = personajesDTO.stream().map(perDto ->
                new Personaje(perDto.getName(), perDto.getHeight(), perDto.getMass(),
                        perDto.getHairColor(), perDto.getSkinColor(), perDto.getEyeColor(),
                        perDto.getBirthYear(), perDto.getGender(), perDto.getHomeWorld(),
                        perDto.getSpecies())).collect(Collectors.toList());
        return personajes;
    }

    private List<PersonajeDTO> fromPersonajeToPersonajeDto(List<Personaje> personajes) {
        List<PersonajeDTO> personajesDto = personajes.stream().map(per ->
                new PersonajeDTO(per.getName(), per.getHeight(), per.getMass(), per.getGender(), per.getHomeWorld(),
                        per.getSpecies())).collect(Collectors.toList());
        return personajesDto;
    }
}
