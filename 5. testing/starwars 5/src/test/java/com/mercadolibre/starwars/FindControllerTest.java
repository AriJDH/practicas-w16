package com.mercadolibre.starwars;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    String personaje;

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Metodo encontrar personaje del controlador")
    void findCharacter(){
        //arrange
        personaje = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO);


        when(findService.find(personaje)).thenReturn(characterDTOList);
        //act
        List<CharacterDTO> expectedCharacters = findController.find(personaje);
        //assert
        Assertions.assertEquals(expectedCharacters,characterDTOList);
        Mockito.verify(findService,Mockito.times(1)).find(personaje);
    }
}
