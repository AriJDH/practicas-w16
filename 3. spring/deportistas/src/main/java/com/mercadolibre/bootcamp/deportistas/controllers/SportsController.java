package com.mercadolibre.bootcamp.deportistas.controllers;

import com.mercadolibre.bootcamp.deportistas.domain.Sport;
import com.mercadolibre.bootcamp.deportistas.dtos.PersonDto;
import com.mercadolibre.bootcamp.deportistas.dtos.SportDto;
import com.mercadolibre.bootcamp.deportistas.services.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SportsController {
    Service service = Service.getInstance();

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getAllSports(){
        return new ResponseEntity(service.getAllSports(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<Sport> getSportByName(@PathVariable String sportName){
        Sport sport = service.searchByName(sportName);
        if(sport == null)
            return new ResponseEntity("no sport matching criteria",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(sport, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDto>> getAllAthletes(){
        return new ResponseEntity(service.getAllSportsman(), HttpStatus.OK);
    }

}
