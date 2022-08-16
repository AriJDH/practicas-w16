package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryImplTest {

    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void whenFindByNameNotMatchShouldReturnEmptyList() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("developer");

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void whenFindByNameThatMatchShouldReturnListWithMatchedCharacters() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.size() >= 1);
    }

}
