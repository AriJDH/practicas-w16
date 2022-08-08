package com.bootcam.starwars.starwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;

    private String homeworld;
    private String species;
    @JsonIgnore
    private Integer height;
    @JsonIgnore
    private Integer mass;
}
