package com.javaW16.deportistas.services;

import com.javaW16.deportistas.entities.Persona;
import com.javaW16.deportistas.entitiesDto.PersonaDTO;
import com.javaW16.deportistas.repository.Repository;

public class ApiServices {

   Repository repository = new Repository();

   public PersonaDTO addPerson(String name,String lastName,Integer age){

     Persona person = new Persona(name,lastName,age);
      repository.addPersona(person);
      return new PersonaDTO(name,lastName,age);



   }

}
