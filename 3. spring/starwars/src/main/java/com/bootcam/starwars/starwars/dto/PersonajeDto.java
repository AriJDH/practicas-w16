package com.bootcam.starwars.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {

        private String name;
        private Integer height;
        private Integer mass;
        private String gender;
        private String homeworld;
        private String species;

}
