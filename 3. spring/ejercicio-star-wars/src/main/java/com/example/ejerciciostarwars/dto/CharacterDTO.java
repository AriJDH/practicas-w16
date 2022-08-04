package com.example.ejerciciostarwars.dto;

import com.example.ejerciciostarwars.entity.Character;
import lombok.Getter;

@Getter
public class CharacterDTO {

    private final String name, gender, homeworld, species;
    private final Integer height, mass;

    public CharacterDTO(Character character) {
        name = character.getName();
        gender = character.getGender();
        homeworld = character.getHomeworld();
        species = character.getSpecies();
        height = character.getHeight();
        mass = character.getMass();
    }

}
