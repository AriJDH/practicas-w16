package com.bootcamp.ejerciciodeporte.services;

import com.bootcamp.ejerciciodeporte.dtos.PersonDto;
import com.bootcamp.ejerciciodeporte.entities.Person;
import com.bootcamp.ejerciciodeporte.entities.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Services {
    private List<Person> persons = new ArrayList<>();
    private List<Sport> sports = new ArrayList<>();

    public Services() {
        loadList();
    }

    public void loadList() {

        sports.add(new Sport("Running", "Middle"));
        sports.add(new Sport("Swimming", "Hard"));
        sports.add(new Sport("Rope Jump", "Low"));
        persons.add(new Person("Pepito", "Perez", 18,this.sports.get(0)));
        persons.add(new Person("Luis", "Suarez", 35,this.sports.get(1)));
        persons.add(new Person("Lionel", "Messi", 34,this.sports.get(1)));
        persons.add(new Person("Lali", "Esposito", 23,this.sports.get(2)));
    }

   public List<Sport> getSports(){
        return this.sports;
   }

   public String getLevelByName(String name){

        Optional<Sport> sport = this.sports.stream().filter(sport1 -> sport1.getName().equals(name)).findFirst();
        if(sport.isPresent()){
            return sport.get().getLevel();
        }else{
            return "El deporte ingresado no existe";
        }
   }

   public List<Person> getPersons(){
        return this.persons;
   }

}
