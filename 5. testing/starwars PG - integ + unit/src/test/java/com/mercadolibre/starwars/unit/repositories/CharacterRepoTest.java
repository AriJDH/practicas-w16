package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CharacterRepoTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findBy(){
        String wordToFind = "Luke";

        List<CharacterDTO> result = characterRepository.findAllByNameContains(wordToFind);

        assertTrue(result.size() == 1);
        assertTrue(result.get(0).getName().equalsIgnoreCase("Luke Skywalker"));

    }

}
