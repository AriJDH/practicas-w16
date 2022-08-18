package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContainsDarth() {
        String query = "Darth";

        List<CharacterDTO> response = repository.findAllByNameContains(query);

        assertEquals(2, response.size());
        response.forEach(character ->
            assertTrue(character.getName().contains(query))
        );
    }

    @Test
    void findAllByNameContainsInvalidQuery() {
        String query = "a random test query";

        List<CharacterDTO> response = repository.findAllByNameContains(query);

        assertEquals(0, response.size());
    }
}