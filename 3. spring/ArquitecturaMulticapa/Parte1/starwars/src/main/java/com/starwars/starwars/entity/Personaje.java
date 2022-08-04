package com.starwars.starwars.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.starwars.starwars.utils.Types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
  
    // public List<Types> destructure(){
    //     List<Types> attrs = new ArrayList<>();
    //     Field[] classAttributes = this.getClass().getDeclaredFields();

    //     for (Field field : classAttributes) {
    //         try {
    //             attrs.add(new Types(field.getGenericType(), field.getName(), field.get(this)));
    //         } catch (IllegalArgumentException | IllegalAccessException e) {
    //             e.printStackTrace();
    //         }
    //     }

    //     attrs.forEach(
    //         attr -> System.out.println(attr)
    //     );

    //     return attrs;
    // }
}
