package com.myapp.deportista.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDTO {
    private String namePerson;
    private String lastNamePerson;
    private String sport;
}
