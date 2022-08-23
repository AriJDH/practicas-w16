package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {


    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    CharacterDTO mockedCharacter;

    @BeforeEach
    void init() {
        mockedCharacter = new CharacterDTO();
        mockedCharacter.setName("Ricardito Mocked");

        when(findService.find(anyString()))
                .thenReturn(new ArrayList<>());

        when(findService.find("Ricardito"))
                .thenReturn(Arrays.asList(mockedCharacter));
    }

    @Test
    void searchTest(){
        List<CharacterDTO> searchResult = findController.find("Ricardito");

        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.get(0).getName() == mockedCharacter.getName());
        verify(findService, atLeastOnce()).find(anyString());
    }

}
