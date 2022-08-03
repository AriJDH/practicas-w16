package com.mercadolibre.bootcamp.deportistas.repositories;

import com.mercadolibre.bootcamp.deportistas.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonRepository extends GenericRepository<Person>{
    public List<Person> getOnlySportmans(){
        return data.stream().filter(Person::isSportPerson).collect(Collectors.toList());
    }
}
