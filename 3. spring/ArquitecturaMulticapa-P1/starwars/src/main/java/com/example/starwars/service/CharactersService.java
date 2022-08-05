package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entities.Character;
import com.example.starwars.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharactersService {

    public List<CharacterDTO> getCharacters(String name){
        List<CharacterDTO> characters = new ArrayList<>();

        CharactersRepository.getCharacters().stream().filter(x -> x.getName().contains(name)).forEach(x->{
            characters.add(new CharacterDTO(x.getName(), x.getHomeworld(), x.getMass(), x.getSpecies(), x.getGender(), x.getHeight()));
        });

        return characters;
    }
}
