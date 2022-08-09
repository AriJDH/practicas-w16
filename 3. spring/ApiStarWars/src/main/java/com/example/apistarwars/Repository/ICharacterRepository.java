package com.example.apistarwars.Repository;

import com.example.apistarwars.Dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {

    List<CharacterDTO> getAllCharacter();
    List<CharacterDTO> getCharacterByName(String name);
}
