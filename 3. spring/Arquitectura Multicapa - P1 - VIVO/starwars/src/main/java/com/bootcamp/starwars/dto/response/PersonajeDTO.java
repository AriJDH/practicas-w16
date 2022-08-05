package com.bootcamp.starwars.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}
