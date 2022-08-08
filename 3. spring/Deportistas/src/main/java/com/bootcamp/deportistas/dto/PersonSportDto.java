package com.bootcamp.deportistas.dto;

import com.bootcamp.deportistas.entities.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSportDto {

    private String name;
    private String lastName;
    private String sportName;

}
