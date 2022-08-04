package com.example.ejerciciostarwars.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Character {

    private final Integer height, mass;
    private final String name, hairColor, eyeColor, skinColor, birthYear, gender, homeworld, species;

    public Boolean isNamedLike(String aName) {
        return name.toLowerCase().contains(aName);
    }

}
