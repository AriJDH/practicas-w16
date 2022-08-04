package com.starwars.app.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.app.dto.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository{

    private final List<CharacterDTO> dataBase;

    public CharacterRepositoryImpl(){
        this.dataBase = loadDataBase();
    }



    @Override
    public List<CharacterDTO> findCharacter(String characterName) {
        return this.dataBase.stream()
                .filter(characterDTO -> matchCharacter(characterName,characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchCharacter(String characterName,CharacterDTO characterDTO){
        return  characterDTO.getName().toLowerCase().contains(characterName.toLowerCase());
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
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
