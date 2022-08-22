package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class RepositoryTest {
    @Autowired
    CharacterRepository repository;

    @Test
    public void findByNameNotNullTest(){
       List<CharacterDTO> list= repository.findAllByNameContains("luke");

        assertNotNull(list);
    }

    @Test
    public void findAllByNameContainsAndAssertsPropertiesTest(){
        List<CharacterDTO> list= repository.findAllByNameContains("luke");
        CharacterDTO characterDTO = list.get(0);

        assertEquals("Luke Skywalker", characterDTO.getName());
        assertEquals("blond", characterDTO.getHair_color());
        assertEquals("fair", characterDTO.getSkin_color());
        assertEquals("blue", characterDTO.getEye_color());
        assertEquals("19BBY", characterDTO.getBirth_year());
        assertEquals("male", characterDTO.getGender());
        assertEquals("Tatooine", characterDTO.getHomeworld());
        assertEquals("Human", characterDTO.getSpecies());
        assertEquals(172, characterDTO.getHeight());
        assertEquals(77, characterDTO.getMass());
    }

    @Test
    public void findByNameValidTest(){
        List<CharacterDTO> list= repository.findAllByNameContains("darth");

        assertEquals("Darth Vader", list.get(0).getName());
        assertEquals("Darth Maul", list.get(1).getName());
    }

}
