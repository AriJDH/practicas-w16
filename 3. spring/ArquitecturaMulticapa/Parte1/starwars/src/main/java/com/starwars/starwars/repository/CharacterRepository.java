package com.starwars.starwars.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.entity.Personaje;

@Repository
public class CharacterRepository implements IRepository {

    private final List<Personaje> characters;

    public CharacterRepository(){
        this.characters = loadData();
    }

    @Override
    public List<Personaje> findAllByNameContains(String name){
        return characters.stream().filter( 
            character -> isContains(character, name)
        ).collect(java.util.stream.Collectors.toList());
    }

    private boolean isContains(Personaje character, String name) {
        return character.getName().toLowerCase().contains(name.toLowerCase());
    }

    private List<Personaje> loadData() {
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:db.json");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<List<Personaje>>() {};
        List<Personaje> characters = null;

        try{
            characters = mapper.readValue(file, typeRef);
        }catch(IOException e){
           e.printStackTrace();
        }

        return characters;
    }
}
