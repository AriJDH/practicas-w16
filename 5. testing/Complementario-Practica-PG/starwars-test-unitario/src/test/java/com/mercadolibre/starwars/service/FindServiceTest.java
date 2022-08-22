package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository mockCharacterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Test para el find del service")
    public void findTest() {

        //Arrange
        String name = "Han Solo";

        List<CharacterDTO> listExpected = new ArrayList<>();

        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setName("Han Solo");
        characterDTOExpected.setBirth_year("1987");
        characterDTOExpected.setGender("M");
        characterDTOExpected.setEye_color("Brown");
        characterDTOExpected.setMass(89);
        characterDTOExpected.setSkin_color("Skin");
        characterDTOExpected.setHeight(176);
        characterDTOExpected.setSpecies("Human");
        characterDTOExpected.setHair_color("Black");
        characterDTOExpected.setHomeworld("World");

        listExpected.add(characterDTOExpected);

        List<CharacterDTO> listResponse = new ArrayList<>();

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Han Solo");
        characterDTO.setBirth_year("1987");
        characterDTO.setGender("M");
        characterDTO.setEye_color("Brown");
        characterDTO.setMass(89);
        characterDTO.setSkin_color("Skin");
        characterDTO.setHeight(176);
        characterDTO.setSpecies("Human");
        characterDTO.setHair_color("Black");
        characterDTO.setHomeworld("World");

        listResponse.add(characterDTO);

        List<CharacterDTO> response;

        //Act
        when(mockCharacterRepository.findAllByNameContains(name)).thenReturn(listResponse);
        response = findService.find(name);

        //Assert
        Assertions.assertEquals(listExpected, response);

    }

}
