package com.bootcamp.starwarsexcercise.repository;


import com.bootcamp.starwarsexcercise.model.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository implements CharacterRepositoryInterface {

    private List<Character> characters;

    private ParseJson p = new ParseJson();

    @Override
    public List<Character> getAllCharacters() {

        return p.returnCharacters();
    }


}
