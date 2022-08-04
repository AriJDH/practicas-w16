package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDto;

import java.util.List;

public interface CharacterServiceInterface {
    List<CharacterDto> findByName(String name);
}
