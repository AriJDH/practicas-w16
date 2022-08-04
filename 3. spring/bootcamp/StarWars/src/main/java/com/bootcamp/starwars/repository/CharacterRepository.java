package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository implements CharacterRepositoryInterface{

    ParseJson parseJson = new ParseJson();

    @Override
    public List<Character> getAllCharacters() {
        return parseJson.returnCharacters();
    }
}
