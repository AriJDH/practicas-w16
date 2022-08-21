package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CharacterRepositoryTest {

    @Autowired
    CharacterRepository repository;

    @Test
    public void findAll(){
        repository = new CharacterRepositoryImpl();
        Assertions.assertEquals(87, repository.findAll().size());
    }


}
