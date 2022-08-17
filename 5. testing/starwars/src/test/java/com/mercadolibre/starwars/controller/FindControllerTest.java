package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    public void findControllerTest(){
        CharacterDTO character= new CharacterDTO("sabrina","rojo","marron","marron","26","-","argentina","humano",21,22);
        List<CharacterDTO> listCharacter= Arrays.asList(character);

        when(service.find("sabrina")).thenReturn(listCharacter);
       List<CharacterDTO> result= controller.find("sabrina");
       assertEquals(listCharacter.get(0).getName(),result.get(0).getName());
    }

}
