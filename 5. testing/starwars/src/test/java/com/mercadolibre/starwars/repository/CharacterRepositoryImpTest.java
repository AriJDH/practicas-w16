package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImpTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    public void testListCharacters() {
        var res = characterRepository.findAllByNameContains("Luke");

        assertNotNull(res);
    }

    @Test
    void notFoundTest() {
        var res = characterRepository.findAllByNameContains("asdasdad");

        assertEquals(0,res.size());
    }
}
