package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    public void findByName(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Bossk"));
        characters.add(new CharacterDTO("Palpatine"));
        characters.add(new CharacterDTO("Luke"));
        characters.add(new CharacterDTO("Luke Skywalker"));
        characters.add(new CharacterDTO("Bobba Luke"));

        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke"));
        expected.add(new CharacterDTO("Luke Skywalker"));
        expected.add(new CharacterDTO("Bobba Luke"));

        Mockito.when(repository.findAll()).thenReturn(characters);

        Assertions.assertEquals(expected, service.find("Luke"));
    }

    @Test
    public void findByNameEmptyCharacters(){
        List<CharacterDTO> characters = new ArrayList<>();

        List<CharacterDTO> expected = new ArrayList<>();

        Mockito.when(repository.findAll()).thenReturn(characters);

        Assertions.assertEquals(expected, service.find("Luke"));
    }

    @Test
    public void findByNameEmptyName(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Bossk"));
        characters.add(new CharacterDTO("Palpatine"));
        characters.add(new CharacterDTO("Luke"));
        characters.add(new CharacterDTO("Luke Skywalker"));
        characters.add(new CharacterDTO("Bobba Luke"));


        Mockito.when(repository.findAll()).thenReturn(characters);

        Assertions.assertEquals(characters, service.find(""));
    }

    @Test
    public void findByNameNotMatch(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Bossk"));
        characters.add(new CharacterDTO("Palpatine"));
        characters.add(new CharacterDTO("Luke"));
        characters.add(new CharacterDTO("Luke Skywalker"));
        characters.add(new CharacterDTO("Bobba Luke"));

        List<CharacterDTO> expected = new ArrayList<>();

        Mockito.when(repository.findAll()).thenReturn(characters);

        Assertions.assertEquals(expected, service.find("aakklaoos"));
    }

}
