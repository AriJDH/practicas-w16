package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindService {
    private final CharacterRepository characterRepository;

    public FindService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> find(String query) {

        return characterRepository.findAll().stream()
                .filter(characterDTO -> characterDTO.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
