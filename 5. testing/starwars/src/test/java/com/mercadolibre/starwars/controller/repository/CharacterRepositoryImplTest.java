package com.mercadolibre.starwars.controller.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public  void loadData(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContainsTest(){
        //Act
        List<CharacterDTO> output = characterRepository.findAllByNameContains("darth");
        //Assert
        Assertions.assertEquals(2,output.size());
        Assertions.assertEquals("Darth Vader",output.get(0).getName());
        Assertions.assertEquals("Darth Maul",output.get(1).getName());
    }
}
