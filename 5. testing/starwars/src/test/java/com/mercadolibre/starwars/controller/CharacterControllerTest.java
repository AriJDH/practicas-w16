package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    public void findControllerTest(){

        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke"));
        expected.add(new CharacterDTO("Luke Skywalker"));
        expected.add(new CharacterDTO("Bobba Luke"));

        Mockito.when(service.find(Mockito.anyString())).thenReturn(expected);
        List<CharacterDTO> result= controller.find("Luke");
        Assertions.assertEquals(expected, result);
    }

}
