package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImplTest {

    @Test
    public void findAllByNameContainsTest(){

        //Arrange
        String name = "Owen";

        List<CharacterDTO> listExpected = new ArrayList<>();

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Owen Lars");
        characterDTO.setBirth_year("52BBY");
        characterDTO.setGender("male");
        characterDTO.setEye_color("blue");
        characterDTO.setMass(120);
        characterDTO.setSkin_color("light");
        characterDTO.setHeight(178);
        characterDTO.setSpecies("Human");
        characterDTO.setHair_color("brown, grey");
        characterDTO.setHomeworld("Tatooine");

        listExpected.add(characterDTO);

        List<CharacterDTO> listResponse;
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

        //Act
        listResponse = characterRepository.findAllByNameContains(name);

        //Assert
        Assertions.assertEquals(listExpected, listResponse);
    }


}
