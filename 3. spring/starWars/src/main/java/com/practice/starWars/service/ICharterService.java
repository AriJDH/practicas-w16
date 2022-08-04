package com.practice.starWars.service;

import com.practice.starWars.dto.CharacterStarWarsDTO;

import java.util.List;

public interface ICharterService {

    List<CharacterStarWarsDTO> foundCharacterByName(String name);
}
