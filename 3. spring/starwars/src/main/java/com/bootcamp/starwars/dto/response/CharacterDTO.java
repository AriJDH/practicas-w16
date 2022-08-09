package com.bootcamp.starwars.dto.response;

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
    private String hairColor;
    @JsonIgnore
    private String skinColor;
    @JsonIgnore
    private String eyeColor;
    @JsonIgnore
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String species;
    private Integer height;
    private Integer mass;


}
