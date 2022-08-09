package com.example.apistarwars.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
//    private Long id;
//    private String name;
//    private int height;
//    private int mass;
//    private String gender;
//    private String homeWorld;
//    private String species;

    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;

}
