package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.bootcamp.starwars.utils.Util;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IRepository<Personaje>{
    private List<Personaje> personajes;

    private void initializeRepo(){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/starwars.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray personajesList = (JSONArray) obj;
            personajesList.forEach(p -> this.personajes.add(Util.parsePersonObject((JSONObject) p)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public PersonajeRepository() {
        this.personajes = new ArrayList<>();
        initializeRepo();
    }

    public List<Personaje> getAll(){
        return this.personajes;
    }

    @Override
    public List<Personaje> getByName(String name) {
        return this.personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
