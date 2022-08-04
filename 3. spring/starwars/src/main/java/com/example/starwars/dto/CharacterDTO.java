package com.example.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private String name;
    private String homeworld;
    private Long mass;
    private String species;
    private String gender;
    private Long height;
}
