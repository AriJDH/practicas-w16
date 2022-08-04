package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> findCharacterByName(String name);

}
