package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.request.QueryDTO;
import com.bootcamp.starwars.dto.response.CharacterDTO;

import java.util.List;

public interface CharacterRepository {

    List<CharacterDTO> finAllByNameContains(String query);
}
