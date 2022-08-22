package com.mercadolibre.starwars;

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

        CharacterDTO character= new CharacterDTO("emanuel","rojo","verde","azul","23","masculino","argentina","humano",21,22);
        //CharacterDTO character1= new CharacterDTO("pedro","rojo","verde","azul","23","masculino","argentina","humano",21,22);
        List<CharacterDTO> listCharacter= Arrays.asList(character);
        when(repository.findAllByNameContains("emanuel")).thenReturn(listCharacter);

        List<CharacterDTO> resultCharacter=service.find("emanuel");

        assertEquals(listCharacter.get(0).getName(),resultCharacter.get(0).getName());

    }
    @Test
    public void findByNameDtoTest(){

        CharacterDTO character= new CharacterDTO();
        character.setName("emanuel");character.setEye_color("rojo");character.setHair_color("verde");
        character.setSkin_color("azul");character.setBirth_year("23");character.setGender("masculino");
        character.setHomeworld("argentina");character.setSpecies("humano");character.setMass(21);character.setHeight(22);
        List<CharacterDTO> listCharacter= Arrays.asList(character);
        when(repository.findAllByNameContains("emanuel")).thenReturn(listCharacter);

        List<CharacterDTO> resultCharacter=service.find("emanuel");

        assertEquals(listCharacter.get(0).getName(),resultCharacter.get(0).getName());

    }


}
