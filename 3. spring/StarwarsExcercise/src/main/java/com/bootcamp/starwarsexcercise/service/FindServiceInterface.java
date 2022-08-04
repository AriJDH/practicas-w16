package com.bootcamp.starwarsexcercise.service;

import com.bootcamp.starwarsexcercise.dto.CharacterDto;

import java.util.List;

public interface FindServiceInterface {

    List<CharacterDto> findByName(String name);
}
