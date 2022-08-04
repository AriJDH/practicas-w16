package com.starwars.app.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private String name;

    @JsonIgnore
    private String hair_color;

    @JsonIgnore
    private String skin_color;

    @JsonIgnore
    private String eye_color;

    @JsonIgnore
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;
}
