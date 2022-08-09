package com.starwars.repository;

import com.starwars.dto.CharacterDTO;
import com.starwars.entity.Character;

import java.util.List;


public interface IRepository {

    public void addCharacters(List<Character> characters);

    public void addCharacter(Character character);

    public List<CharacterDTO> getCharacters();

    public List<CharacterDTO> searchByName(String name);

}
