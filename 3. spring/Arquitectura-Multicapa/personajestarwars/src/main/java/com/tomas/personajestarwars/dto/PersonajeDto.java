package com.tomas.personajestarwars.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {

    private String name;
    private int heigh;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;

}