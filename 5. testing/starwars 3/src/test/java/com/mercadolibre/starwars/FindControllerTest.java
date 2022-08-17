package com.mercadolibre.starwars;

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
        CharacterDTO character= new CharacterDTO("emanuel","rojo","verde","azul","23","masculino","argentina","humano",21,22);
        //CharacterDTO character1= new CharacterDTO("pedro","rojo","verde","azul","23","masculino","argentina","humano",21,22);
        List<CharacterDTO> listCharacter= Arrays.asList(character);

        when(service.find("emanuel")).thenReturn(listCharacter);
       List<CharacterDTO> result= controller.find("emanuel");
       assertEquals(listCharacter.get(0).getName(),result.get(0).getName());
    }

}
