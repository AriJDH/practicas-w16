package com.ndemaio.ejerciciodeportistas.dto;

import com.ndemaio.ejerciciodeportistas.entity.Person;
import lombok.Getter;

@Getter
public class PersonDTO {

    private final String name, lastName, sportName;

    public PersonDTO(Person person) {
        this.name = person.getName();
        this.lastName = person.getSurname();
        this.sportName = person.getSport().getName();
    }
}
