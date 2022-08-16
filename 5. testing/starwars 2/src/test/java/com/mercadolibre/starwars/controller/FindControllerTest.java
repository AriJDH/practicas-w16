package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService mockFindService;

    @InjectMocks
    private FindController findController;


    @Test
    void shouldFindCharactersByName() {
        //Arrange
        String query = "Luke";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Luke Skywalker");
        characterDTO1.setHair_color("blond");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Luke Floorwalker");
        characterDTO2.setHair_color("black");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1, characterDTO2);

        when(mockFindService.find(query)).thenReturn(characterDTOList);

        //Act
        List<CharacterDTO> result = findController.find(query);

        //Assert
        assertEquals(result.size(),2);
    }

    @Test
    void shuouldFindOneCharacterByName(){
        String query = "Luke";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Luke Skywalker");
        characterDTO1.setHair_color("blond");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setName("Luk Floorwalker");
        characterDTO2.setHair_color("black");

        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO1);

        when(mockFindService.find(query)).thenReturn(characterDTOList);

        List<CharacterDTO> result = findController.find(query);

        assertEquals(result.get(0).getName(), "Luke Skywalker");
    }
}
