package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {

    CharacterRepositoryImpl characterRepository;
    String character;
    List<CharacterDTO> expectedCharacter;

    @BeforeEach
    void initializeRepository(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Encontrar un personaje")
    void encontrarPersonaje(){
        //Arrange
        character = "Darth";
        //Act
        expectedCharacter = characterRepository.findAllByNameContains(character);
        //Assert
        Assertions.assertEquals(2,expectedCharacter.size());
    }

    @Test
    @DisplayName("Encontrar un personaje")
    void encontrarPersonajeDos(){
        //Arrange
        character = "Luke";
        //Act
        expectedCharacter = characterRepository.findAllByNameContains(character);
        //Assert
        Assertions.assertEquals(1,expectedCharacter.size());

    }
}
