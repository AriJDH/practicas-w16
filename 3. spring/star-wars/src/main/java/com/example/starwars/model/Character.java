package com.example.starwars.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Character {

    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String species;

}
