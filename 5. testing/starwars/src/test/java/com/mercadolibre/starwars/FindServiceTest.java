package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;


    @Test
    public void findTest() {
        //Arrage
        CharacterDTO pj = new CharacterDTO("Luke Skywalker", "Tatooine", "Human", "blond", "fair", "blue", "19BBY", "male", 172, 77);
        List<CharacterDTO> database = new ArrayList<>();
        database.add(pj);
        Mockito.when(repository.findAllByNameContains(pj.getName())).thenReturn(database);

        List<CharacterDTO> result = service.find(pj.getName());
        //Act && Assert
        verify(repository, atLeastOnce()).findAllByNameContains(pj.getName());
        Assertions.assertEquals(1, result.size());
    }

    @Test

    public void findTestFail() {

        //Arrage
        CharacterDTO pj = new CharacterDTO("Luke Skywalker", "Tatooine", "Human", "blond", "fair", "blue", "19BBY", "male", 172, 77);
        Mockito.when(repository.findAllByNameContains(pj.getName())).thenReturn(new ArrayList<>());

        List<CharacterDTO> result = service.find(pj.getName());
        //Act && Assert
        verify(repository, atLeastOnce()).findAllByNameContains(pj.getName());
        Assertions.assertEquals(0, result.size());

    }


}
