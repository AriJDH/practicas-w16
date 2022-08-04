package com.practice.starWars.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterStarWars {

    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String home_world;
    private String species;
    private Integer height;
    private Integer mass;
}
