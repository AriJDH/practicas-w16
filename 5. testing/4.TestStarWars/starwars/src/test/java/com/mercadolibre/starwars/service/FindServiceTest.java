package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

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

        when(characterRepository.findAllByNameContains(any())).thenReturn(List.of(characterDTO));

        var result = findService.find("Jar").stream().findFirst().get();

        assertEquals(characterDTO.getName(), result.getName() );
    }


    @Test
    void findNotFound() {

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

        when(characterRepository.findAllByNameContains(any())).thenReturn(List.of());

        var result = findService.find("Yenny");

        assertTrue(result.isEmpty());
    }
}