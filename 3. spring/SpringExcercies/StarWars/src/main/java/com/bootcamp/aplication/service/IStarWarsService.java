package com.bootcamp.aplication.service;

import com.bootcamp.aplication.dto.SWCharacterDTO;
import com.bootcamp.aplication.entity.SWCharacter;

import java.util.List;

public interface IStarWarsService {

    List<SWCharacter> getDataCharacters();

    List<SWCharacterDTO> findCharacter(String s);
}
