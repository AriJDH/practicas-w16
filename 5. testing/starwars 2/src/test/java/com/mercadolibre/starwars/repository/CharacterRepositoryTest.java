package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {
    CharacterRepository characterRepository;

    @BeforeEach
    private void setUp(){
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findByNameTest(){
        String name = "Luke";

        List<CharacterDTO> characterDTOS = this.characterRepository.findAllByNameContains(name);

        Assertions.assertTrue(characterDTOS.get(0).getName().toUpperCase().contains(name.toUpperCase()));
    }

    @Test
    public void findByEmptyNameTest(){
        String name = "";

        List<CharacterDTO> characterDTOS = this.characterRepository.findAllByNameContains(name);

        Assertions.assertTrue(characterDTOS.size()>0);
    }

    @Test
    public void findBySimilarNameTest(){
        String name = "Dart";
        List<CharacterDTO> characterDTOS = this.characterRepository.findAllByNameContains(name);

        Assertions.assertTrue(characterDTOS.size() == 2);
    }
}
