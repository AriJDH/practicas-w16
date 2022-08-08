package com.example.starwars.repository;

import com.example.starwars.entities.Character;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CharactersRepository {

    private static List<Character> characters = new ArrayList<>();

    public static List<Character> getCharacters(){
        if (characters.isEmpty()) {
            JSONParser parser = new JSONParser();
            try {
                JSONArray a = (JSONArray) parser.parse(new FileReader("/Users/sopetrides/Desktop/starwars/src/main/resources/3. starwars.json"));

                for (Object o : a) {
                    JSONObject json = (JSONObject) o;

                    Character character = new Character();
                    character.setBirth_year((String) json.get("birth_year"));
                    character.setGender((String) json.get("gender"));
                    character.setEye_color((String) json.get("eye_color"));

                    try {
                        Long height = (Long) json.get("height");
                        character.setHeight((Long) json.get("height"));
                    } catch (ClassCastException e) {
                        character.setHeight(0L);
                    }

                    character.setHomeworld((String) json.get("homeworld"));
                    character.setHair_color((String) json.get("hair_color"));

                    try {
                        Long mass = (Long) json.get("mass");
                        character.setMass((Long) json.get("mass"));
                    } catch (ClassCastException e) {
                        character.setMass(0L);
                    }

                    character.setName((String) json.get("name"));
                    character.setSkin_color((String) json.get("skin_color"));
                    character.setSpecies((String) json.get("species"));

                    characters.add(character);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return characters;
    }



}
