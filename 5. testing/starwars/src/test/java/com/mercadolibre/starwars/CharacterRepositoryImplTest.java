package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CharacterRepositoryImplTest {


    CharacterRepository repository;

    CharacterDTO pj;


    @BeforeEach
    private void init() {
        this.repository = new CharacterRepositoryImpl();
        List<CharacterDTO> characterDTOList = new ArrayList<>();

    }


    @Test
    public void findAllByNameContains() {

        Optional<List<CharacterDTO>> list = Optional.of(repository.findAllByNameContains("Luke Skywalker"));
        Assertions.assertTrue(list.isPresent());
    }
}
