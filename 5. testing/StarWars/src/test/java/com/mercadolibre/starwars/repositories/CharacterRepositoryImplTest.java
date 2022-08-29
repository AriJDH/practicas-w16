package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CharacterRepositoryImplTest {
    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void findAllByNameContainsTest() {
        List<CharacterDTO> characterDTOListResult = this.characterRepository.findAllByNameContains("Luke");

        assertEquals(1, characterDTOListResult.size());
    }

    @Test
    public void findAllByNameContainsAndAssertsPropertiesTest() {
        List<CharacterDTO> characterDTOListResult = this.characterRepository.findAllByNameContains("Luke");
        CharacterDTO characterDTO = characterDTOListResult.get(0);

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
    public void findAllByNameContainsWithTwoFoundsTest() {
        List<CharacterDTO> characterDTOListResult = this.characterRepository.findAllByNameContains("Darth");

        assertEquals("Darth Vader", characterDTOListResult.get(0).getName());
        assertEquals("Darth Maul", characterDTOListResult.get(1).getName());
    }

}
