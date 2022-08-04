package com.practice.starWars.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterStarWarsDTO {
    private String name;
    private String gender;
    private String home_world;
    private String species;
    private Integer height;
    private Integer mass;
}
