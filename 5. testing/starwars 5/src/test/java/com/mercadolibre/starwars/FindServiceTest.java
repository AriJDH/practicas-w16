package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Encontrar personaje , metodo del service")
    void encontrarPersonaje(){
        //Arrange
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


        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO);

        when(characterRepository.findAllByNameContains("Luke")).thenReturn(characterDTOList);
        //Act
        List<CharacterDTO> newCharacter = findService.find("Luke");

        //Assert
        Assertions.assertEquals(characterDTOList.get(0).getName(),newCharacter.get(0).getName());
        Assertions.assertEquals(characterDTOList.get(0).getMass(),newCharacter.get(0).getMass());
    }
}
