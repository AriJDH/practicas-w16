package com.spring.personajes_star_wars.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

}
