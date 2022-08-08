package com.bootcam.starwars.starwars.service;

import com.bootcam.starwars.starwars.dto.PersonajeDto;
import com.bootcam.starwars.starwars.repository.PersonaRepo;
import com.bootcam.starwars.starwars.repository.Repository;
import com.bootcam.starwars.starwars.utils.PersonajeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class StarWarsSvc {
    private PersonaRepo repo = new PersonaRepo();

    public List<PersonajeDto> findCharacter(String name)
    {
        return repo.characters.where(c -> c.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).
                stream().map(PersonajeMapper::entityToDto).collect(Collectors.toList());
    }
}
