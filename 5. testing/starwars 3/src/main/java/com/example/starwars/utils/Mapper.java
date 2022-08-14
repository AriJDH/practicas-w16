package com.example.starwars.utils;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;

public class Mapper {

    public static CharacterDTO DTOFromCharacter( Character character){
        return new CharacterDTO(
          character.getName(),
          character.getHeight(),
          character.getMass(),
          character.getGender(),
          character.getHomeworld(),
          character.getSpecies()
        );
    }
}
