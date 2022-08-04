package com.example.starwars.service;

import com.example.starwars.dto.CharacterDto;

import java.util.List;

public interface FindServiceInterface {

    List<CharacterDto> findByName(String name);
}
