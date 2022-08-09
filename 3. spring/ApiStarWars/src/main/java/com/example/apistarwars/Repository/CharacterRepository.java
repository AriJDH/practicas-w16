package com.example.apistarwars.Repository;

import com.example.apistarwars.Dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterRepository implements ICharacterRepository{

    private final List<CharacterDTO> listCharacter;

    public CharacterRepository() {
        this.listCharacter = loadDataBase();
    }

    @Override
    public List<CharacterDTO> getAllCharacter() {
        return this.listCharacter;
    }

    @Override
    public List<CharacterDTO> getCharacterByName(String name) {
        return listCharacter.stream()
                .filter(characterDTO -> matchWith(name,characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<CharacterDTO> loadDataBase() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
