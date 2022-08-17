package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.PersonajeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonajesTest {
    @Autowired
    private Personajes personajes;

    List<PersonajeDTO> characterList;

    @Test
    void findByNameNullTest(){
        //Act
        characterList = personajes.encontrarPersonajes("Paul Skyrunner");
        //Assert
        assertTrue(characterList.isEmpty());
    }

    @Test
    void findByNameNotNullTest(){
        //Act
        characterList = personajes.encontrarPersonajes("Owen Lars");
        //Assert
        assertFalse(characterList.isEmpty());
    }

    @Test
    void loadEveryCharacterFromDatabaseNoExceptionThrown(){
        //Assert
        assertDoesNotThrow(() -> personajes.cargarPersonajes());
    }



}
