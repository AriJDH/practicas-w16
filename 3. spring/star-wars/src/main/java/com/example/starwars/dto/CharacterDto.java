package com.example.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CharacterDto {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeWorld;
    private String species;

}
