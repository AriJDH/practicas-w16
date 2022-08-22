package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    static List<CharacterDTO> characterDTOS = new ArrayList<>();
    private static void initSources(){
        if(characterDTOS.size() > 0) return;
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setBirth_year("19BBY");
        characterDTO1.setEye_color("blue");
        characterDTO1.setGender("male");
        characterDTO1.setHeight(172);
        characterDTO1.setHomeworld("Tatooine");
        characterDTO1.setMass(77);
        characterDTO1.setName("Darth Maul");
        characterDTO1.setSkin_color("fair");
        characterDTO1.setSpecies("Human");
        characterDTO1.setHair_color("blond");

        CharacterDTO characterDTO2 = new CharacterDTO();
        characterDTO2.setBirth_year("19BBY");
        characterDTO2.setEye_color("blue");
        characterDTO2.setGender("male");
        characterDTO2.setHeight(172);
        characterDTO2.setHomeworld("Tatooine");
        characterDTO2.setMass(77);
        characterDTO2.setName("Luke Skywalker");
        characterDTO2.setSkin_color("fair");
        characterDTO2.setSpecies("Human");
        characterDTO2.setHair_color("blond");

        CharacterDTO characterDTO3 = new CharacterDTO();
        characterDTO3.setBirth_year("19BBY");
        characterDTO3.setEye_color("blue");
        characterDTO3.setGender("male");
        characterDTO3.setHeight(172);
        characterDTO3.setHomeworld("Tatooine");
        characterDTO3.setMass(77);
        characterDTO3.setName("Darth Vader");
        characterDTO3.setSkin_color("fair");
        characterDTO3.setSpecies("Human");
        characterDTO3.setHair_color("blond");

        characterDTOS =  Arrays.asList(
                characterDTO1, characterDTO2, characterDTO3
        );
    }

    public static List<CharacterDTO> findAll(){
        if(characterDTOS.size() == 0) initSources();
        return characterDTOS;
    }

    public static List<CharacterDTO> findAllByNameContains(String query) {
        if(characterDTOS.size() == 0) initSources();
        return characterDTOS.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
                .collect(Collectors.toList());
    }

    private static boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }


}
