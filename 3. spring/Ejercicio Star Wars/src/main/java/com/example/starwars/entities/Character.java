package com.example.starwars.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    private String name;
    private String homeworld;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private Long mass;
    private String species;
    private String birth_year;
    private String gender;
    private Long height;
}
