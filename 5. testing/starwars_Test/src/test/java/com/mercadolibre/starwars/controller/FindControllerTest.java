package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    CharacterDTO characterDTO;

    @BeforeEach
    public void initializeCharacter(){

        characterDTO = new CharacterDTO();
        characterDTO.setName("Jar jar Binks");
        characterDTO.setHair_color("No hair");
        characterDTO.setSkin_color("Brown");
        characterDTO.setEye_color("Yellow");
        characterDTO.setBirth_year("32ABY");
        characterDTO.setGender("Male");
        characterDTO.setHomeworld("Naboo");
        characterDTO.setSpecies("Gungan");
        characterDTO.setHeight(190);
        characterDTO.setMass(70);
    }

    @Test
    public void givenNameFindCharacter(){

        when(findService.find(any())).thenReturn(List.of(characterDTO));

        var actual = findController.find("jar jar").stream().findFirst().get();

        assertEquals(characterDTO.getName(), actual.getName());

    }

    @Test
    public void givenNameThenDontFindCharacter(){

        when(findService.find(any())).thenReturn(List.of());

        var actual = findController.find("wue");

        assertTrue(actual.isEmpty());

    }

}