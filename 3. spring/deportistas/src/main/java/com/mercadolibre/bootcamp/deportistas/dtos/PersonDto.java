package com.mercadolibre.bootcamp.deportistas.dtos;

import com.mercadolibre.bootcamp.deportistas.domain.Person;
import lombok.Data;

@Data
public class PersonDto {
    private String name;
    private String lastName;
    private SportDto sport;

    public PersonDto(Person person){
        name= person.getName();
        lastName = person.getLastName();
        if(person.isSportPerson())
            sport = new SportDto(person.getSport().getName());
    }
}
