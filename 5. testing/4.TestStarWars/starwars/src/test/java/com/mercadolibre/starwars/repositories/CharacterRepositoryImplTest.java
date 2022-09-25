package com.mercadolibre.starwars.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository= new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains() {

        String name = "Greedo";

        var result = characterRepository.findAllByNameContains(name).stream().findFirst().get();

        assertEquals(name,result.getName());
    }

    @Test
    void findAllByNameContainsNotFound() {

        String name = "Yenny";

        var result = characterRepository.findAllByNameContains(name);

        assertTrue(result.isEmpty());
    }

}