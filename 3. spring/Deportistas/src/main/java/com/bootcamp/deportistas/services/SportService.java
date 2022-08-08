package com.bootcamp.deportistas.services;

import com.bootcamp.deportistas.dto.PersonSportDto;
import com.bootcamp.deportistas.dto.SportDto;
import com.bootcamp.deportistas.entities.Sport;
import com.bootcamp.deportistas.repository.PersonRepo;
import com.bootcamp.deportistas.repository.SportRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportService {

    public List<SportDto> getAllSports(){
      return   SportRepo.getAllSports().stream().map(sport -> new SportDto(sport.getName(), sport.getLevel())).collect(Collectors.toList());
    }

    public SportDto getSportByName(String name){

        Sport sport = SportRepo.getSportByName(name);
        return new SportDto(sport.getName(), sport.getLevel());
    }

    public List<PersonSportDto> findPersonSport(){

      return   PersonRepo.getAllPersons().stream()
              .filter(person -> person.getSport() != null)
              .map(person -> new PersonSportDto(person.getName(), person.getLastName(), person.getSport().getName()))
              .collect(Collectors.toList());

    }

}
