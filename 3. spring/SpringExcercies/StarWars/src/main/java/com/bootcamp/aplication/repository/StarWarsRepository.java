package com.bootcamp.aplication.repository;

import com.bootcamp.aplication.entity.SWCharacter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class StarWarsRepository {

    private List<SWCharacter> characterList = new ArrayList<>();

    public StarWarsRepository() {
        this.characterList = loadCharacter();
    }

    private List<SWCharacter> loadCharacter() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starWars.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<SWCharacter>> typeRef = new TypeReference<>() {};
        List<SWCharacter> charactersList = null;

        try {
            charactersList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charactersList;
    }
}
