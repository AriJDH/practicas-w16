package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    public void findByNameTest(){

        CharacterDTO character= new CharacterDTO("sabrina","rojo","marron","marron","26","-","argentina","humano",21,22);
        List<CharacterDTO> listCharacter= Arrays.asList(character);
        when(repository.findAllByNameContains("sabrina")).thenReturn(listCharacter);

        List<CharacterDTO> resultCharacter=service.find("sabrina");

        assertEquals(listCharacter.get(0).getName(),resultCharacter.get(0).getName());

    }
    @Test
    public void findByNameDtoTest(){

        CharacterDTO character= new CharacterDTO();
        character.setName("sabrina");character.setEye_color("marron");character.setHair_color("rojo");
        character.setSkin_color("marron");character.setBirth_year("26");character.setGender("-");
        character.setHomeworld("argentina");character.setSpecies("humano");character.setMass(21);character.setHeight(22);
        List<CharacterDTO> listCharacter= Arrays.asList(character);
        when(repository.findAllByNameContains("sabrina")).thenReturn(listCharacter);

        List<CharacterDTO> resultCharacter=service.find("sabrina");

        assertEquals(listCharacter.get(0).getName(),resultCharacter.get(0).getName());

    }


}
