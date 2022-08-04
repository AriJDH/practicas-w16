package com.example.starwars.repository;


import com.example.starwars.model.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository implements CharacterRepositoryInterface {

    private ParseJson p = new ParseJson();

    @Override
    public List<Character> getAllCharacters() {

        return p.returnCharacters();
    }


}
