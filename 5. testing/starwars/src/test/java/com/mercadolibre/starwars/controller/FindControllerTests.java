package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    public void findTest(){

        //Arrange
        String query = "darth";

        CharacterDTO ch1 = new CharacterDTO();
        ch1.setName("Darth Vader");
        ch1.setHeight(202);
        ch1.setMass(136);
        ch1.setHairColor("none");
        ch1.setSkinColor("white");
        ch1.setEyeColor("yellow");
        ch1.setBirthYear("41.9BBY");
        ch1.setGender("male");
        ch1.setHomeWorld("Tatooine");
        ch1.setSpecies("Human");

        CharacterDTO ch2 = new CharacterDTO();
        ch2.setName("Darth Maul");
        ch2.setHeight(175);
        ch2.setMass(80);
        ch2.setHairColor("none");
        ch2.setSkinColor("red");
        ch2.setEyeColor("yellow");
        ch2.setBirthYear("54BBY");
        ch2.setGender("male");
        ch2.setHomeWorld("Dathomir");
        ch2.setSpecies("Zabrak");

        List<CharacterDTO> expected = new ArrayList<>(List.of(ch1, ch2));

        when(service.find(query)).thenReturn(expected);
        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        verify(service, atLeastOnce()).find(query);
        assertEquals(expected, result);
    }

    @Test
    public void findFailsTest(){

        //Arrange
        String query = "asdasdasd";

        List<CharacterDTO> expected = new ArrayList<>();
        when(service.find(query)).thenReturn(expected);

        //Act
        List<CharacterDTO> result = controller.find(query);

        //Assert
        verify(service, atLeastOnce()).find(query);
        assertEquals(expected, result);
    }

}
