package com.bootcamp.starwars.utils;

import com.bootcamp.starwars.dto.response.PersonajeDTO;
import com.bootcamp.starwars.entity.Personaje;
import org.json.simple.JSONObject;

public class Util {
    public static Personaje parsePersonObject(JSONObject object){
        System.out.println(object);
        Personaje personaje = new Personaje();
        personaje.setEyeColor((String) object.get("eye_color"));
        personaje.setGender((String) object.get("gender"));
        personaje.setBirthYear((String) object.get("birth_year"));
        personaje.setHomeworld((String) object.get("homeworld"));
        try {
            personaje.setHeight(((Long) object.get("height")).intValue());
        }catch (Exception e){
            personaje.setHeight(20);
        }
        try {
            personaje.setMass(((Long) object.get("mass")).intValue());
        }catch (Exception e){
            personaje.setMass(60);
        }
        personaje.setSkinColor((String) object.get("skin_color"));
        personaje.setSpecies((String) object.get("species"));
        personaje.setName((String) object.get("name"));
        personaje.setHairColor((String) object.get("hair_color"));
        return personaje;
    }

    public static PersonajeDTO parsePersonajeToPeronajeDTO(Personaje personaje){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setGender(personaje.getGender());
        personajeDTO.setHeight(personaje.getHeight());
        personajeDTO.setMass(personaje.getMass());
        personajeDTO.setName(personaje.getName());
        personajeDTO.setSpecies(personaje.getSpecies());
        personajeDTO.setHomeworld(personaje.getHomeworld());
        return personajeDTO;
    }
}
