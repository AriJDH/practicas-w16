package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    public void givenExistingNameThenReturnCharacter(){

        String name = "Chewbacca";

        var actual = characterRepository.findAllByNameContains(name).stream().findFirst().get();

        assertEquals(name, actual.getName());

    }

    @Test
    public void givenNonExistingNameThenReturnEmptyList(){

        String name = "Wuher";

        var actual = characterRepository.findAllByNameContains(name);

        assertTrue(actual.isEmpty());

    }

}