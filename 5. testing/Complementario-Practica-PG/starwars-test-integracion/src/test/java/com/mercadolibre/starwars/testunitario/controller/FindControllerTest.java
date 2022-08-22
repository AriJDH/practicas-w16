package com.mercadolibre.starwars.testunitario.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
public class FindControllerTest {

    @Mock
    FindService mockFindService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Test para el find del controller")
    public void findTest(){

        //Arrange
        String name = "Yoda";

        List<CharacterDTO> listExpected = new ArrayList<>();

        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setName("Yoda");
        characterDTOExpected.setBirth_year("2005");
        characterDTOExpected.setGender("M");
        characterDTOExpected.setEye_color("Brown");
        characterDTOExpected.setMass(32);
        characterDTOExpected.setSkin_color("Green");
        characterDTOExpected.setHeight(23);
        characterDTOExpected.setSpecies("NN");
        characterDTOExpected.setHair_color("White");
        characterDTOExpected.setHomeworld("NN");

        listExpected.add(characterDTOExpected);

        List<CharacterDTO> listResponse = new ArrayList<>();

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Yoda");
        characterDTO.setBirth_year("2005");
        characterDTO.setGender("M");
        characterDTO.setEye_color("Brown");
        characterDTO.setMass(32);
        characterDTO.setSkin_color("Green");
        characterDTO.setHeight(23);
        characterDTO.setSpecies("NN");
        characterDTO.setHair_color("White");
        characterDTO.setHomeworld("NN");

        listResponse.add(characterDTO);

        List<CharacterDTO> response;

        //Act
        when(mockFindService.find(name)).thenReturn(listResponse);
        response = findController.find(name);

        //Assert
        Assertions.assertEquals(listExpected, response);

    }

}
