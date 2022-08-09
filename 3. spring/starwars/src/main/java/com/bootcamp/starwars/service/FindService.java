package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.request.QueryDTO;
import com.bootcamp.starwars.dto.response.CharacterDTO;
import com.bootcamp.starwars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
    private final CharacterRepository characterRepository;

    public FindService(CharacterRepository characterRepository) { this.characterRepository = characterRepository; }

    public List<CharacterDTO> find(String query) { return characterRepository.finAllByNameContains(query); }
}
