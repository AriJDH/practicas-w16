package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.apache.commons.collections4.CollectionUtils;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    void findDarth() {
        List<CharacterDTO> characters = new ArrayList<>(2);

        CharacterDTO c1 = new CharacterDTO();
        c1.setName("Darth Vader");
        c1.setHeight(202);
        c1.setMass(136);

        CharacterDTO c2 = new CharacterDTO();
        c2.setName("Darth Maul");
        c2.setHeight(175);
        c2.setMass(80);

        characters.add(c1);
        characters.add(c2);

        String query = "Darth";
        when(repository.findAllByNameContains(query)).thenReturn(characters);

        List<CharacterDTO> response = service.find(query);

        assertTrue(CollectionUtils.isEqualCollection(characters, response));
        verify(repository, atLeastOnce()).findAllByNameContains(query);
    }

    @Test
    void findNone() {
        List<CharacterDTO> characters = new ArrayList<>();

        String query = "a random test query";
        when(repository.findAllByNameContains(query)).thenReturn(characters);

        List<CharacterDTO> response = service.find(query);

        assertTrue(CollectionUtils.isEqualCollection(characters, response));
        verify(repository, atLeastOnce()).findAllByNameContains(query);
    }
}