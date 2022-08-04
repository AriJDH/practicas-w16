package com.bootcamp.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;

}
