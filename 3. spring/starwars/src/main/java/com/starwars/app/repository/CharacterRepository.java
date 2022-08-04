package com.starwars.app.repository;

import com.starwars.app.dto.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CharacterRepository {

    public List<CharacterDTO> findCharacter(String characterName);
}
