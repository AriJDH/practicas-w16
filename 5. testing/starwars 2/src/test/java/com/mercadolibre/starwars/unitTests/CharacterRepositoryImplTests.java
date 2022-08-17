package com.mercadolibre.starwars.unitTests;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTests {

    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findByNameOk(){
        CharacterDTO char1 = new CharacterDTO();
        char1.setName("Darth Vader");
        char1.setHeight(202);
        char1.setMass(136);
        char1.setGender("male");
        char1.setBirth_year("41.9BBY");
        char1.setHomeworld("Tatooine");
        char1.setSpecies("Human");
        char1.setEye_color("yellow");
        char1.setSkin_color("white");
        char1.setHair_color("none");

        CharacterDTO char2 = new CharacterDTO();
        char2.setName("Darth Maul");
        char2.setHeight(175);
        char2.setMass(80);
        char2.setGender("male");
        char2.setBirth_year("54BBY");
        char2.setHomeworld("Dathomir");
        char2.setSpecies("Zabrak");
        char2.setEye_color("yellow");
        char2.setSkin_color("red");
        char2.setHair_color("none");

        List<CharacterDTO> expected = new ArrayList<>(List.of(char1, char2));

        List<CharacterDTO> response =characterRepository.findAllByNameContains("Darth");

        Assertions.assertTrue(CollectionUtils.isEqualCollection(expected, response));
    }

    @Test
    public void findByNameEmpty(){

        List<CharacterDTO> expected = new ArrayList<>();

        List<CharacterDTO> response =characterRepository.findAllByNameContains("sofia");

        Assertions.assertTrue(CollectionUtils.isEqualCollection(expected, response));
    }


    @Test
    public void findByNameNull(){
        Assertions.assertThrows(NullPointerException.class, () -> characterRepository.findAllByNameContains(null));
    }
}
