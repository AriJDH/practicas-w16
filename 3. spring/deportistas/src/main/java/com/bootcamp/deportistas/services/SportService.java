package com.bootcamp.deportistas.services;

import com.bootcamp.deportistas.dto.PersonDTO;
import com.bootcamp.deportistas.dto.SportDTO;
import com.bootcamp.deportistas.entities.Person;
import com.bootcamp.deportistas.entities.Sport;
import com.bootcamp.deportistas.repos.PersonsRepo;
import com.bootcamp.deportistas.repos.SportsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SportService {

    public List<SportDTO> getAllSports(){
        return   SportsRepo.getAllSports().stream().map(sport -> new SportDTO(sport.getName(), sport.getLevel())).collect(Collectors.toList());
    }

    public SportDTO getSport(String sportName){
        Sport sport = SportsRepo.getSport(sportName);
        return new SportDTO(sport.getName(), sport.getLevel());
    }

    public List<PersonDTO> getPersons(){
        List<PersonDTO> persons = new ArrayList<>();
        for (Person person : PersonsRepo.getAllPersons()) {
            if (!person.getSports().isEmpty()) {
                List<String> sports = new ArrayList<>();
                person.getSports().forEach(s -> sports.add(s.getName()));
                persons.add(new PersonDTO(person.getName(), person.getLastName(), sports));
            }
        }

        return persons;
    }
}
