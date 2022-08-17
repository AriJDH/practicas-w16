package com.mercadolibre.starwars.controller.Service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findTest(){
        //Arrange
        CharacterDTO vader = new CharacterDTO("Darth Vader","none","white","Yellow","41.9BBY","male","Tatooine","human",202,136);
        CharacterDTO maul = new CharacterDTO("Darth Maul","none","red","Yellow","54BBY","male","Dathomir","Zabrak",175,80);
        List<CharacterDTO> expectedValue = Arrays.asList(vader,maul);
        when(characterRepository.findAllByNameContains("Darth")).thenReturn(expectedValue);
        //Act
        List<CharacterDTO> outputValue = findService.find("Darth");
        //Assert
        Assertions.assertEquals(expectedValue,outputValue);
    }

}
