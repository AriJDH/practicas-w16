package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDto;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CharacterService {

    private CharacterRepository characterRepositories;
    CharacterRepository characterRepository = new CharacterRepository();

    public List<CharacterDto> findAllCharacter(String name){

        return characterRepository.findByName(name);
    }

}
