package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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

    @Test
    void find() {
        CharacterDTO characterDTO= new CharacterDTO();
        characterDTO.setName("Yenny Ch");
        characterDTO.setHair_color("brown");
        characterDTO.setSkin_color("white");
        characterDTO.setEye_color("brown");
        characterDTO.setBirth_year("2022");
        characterDTO.setGender("F");
        characterDTO.setHomeworld("hhh");
        characterDTO.setSpecies("Vzlna");
        characterDTO.setHeight(150);
        characterDTO.setMass(25);

        when(findService.find(any())).thenReturn(List.of(characterDTO));

        var name = findController.find("Yenny").stream().findFirst().get();

        assertEquals(characterDTO.getName(), name.getName());

    }


}