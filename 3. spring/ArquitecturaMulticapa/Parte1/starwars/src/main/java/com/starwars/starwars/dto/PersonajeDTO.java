package com.starwars.starwars.dto;

import java.lang.reflect.Field;
import java.util.List;

import com.starwars.starwars.entity.Personaje;
import com.starwars.starwars.utils.Types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    // public void destructuring(Personaje character){
    //     Field[] classAttributes = getClass().getDeclaredFields();
    //     List<Types> characterAttributes = character.destructure();
        
    //     for (Field field : classAttributes) {
    //         for (Types attr : characterAttributes) {
    //             if(field.getName().equals(attr.getName())){
    //                 try {
    //                     field.set(this, attr.getValue());
    //                 } catch (IllegalArgumentException | IllegalAccessException e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //         }
    //     }
    // }
}
