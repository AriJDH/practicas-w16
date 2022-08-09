package com.ejerciciodate2.spring.controllers;

import com.ejerciciodate2.spring.domain.Sport;
import com.ejerciciodate2.spring.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {
    @Autowired
    SportsService sportsService;

    @GetMapping("/findSports")
    public  ResponseEntity<List<Sport>>findSports() {
        //Ver todos los deportes que tenemos cargados
        List<Sport> sports = this.sportsService.getSports();
        return new ResponseEntity<List<Sport>>(sports, HttpStatus.OK);
    }
    @GetMapping("/findSports/{name}")
    public ResponseEntity<Sport> findSportsByName(@PathVariable String name) {
    /*
    Consultar si existe un deporte ingresando su nombre.
    De existir, se deberá mostrar el nivel del mismo.
    Utilizar la clase ResponseEntity para devolver la respuesta.
    */
        Sport sport = this.sportsService.getSportsByName(name);
        return new ResponseEntity<Sport>(sport, HttpStatus.OK);

    }
    @GetMapping("/findSportsPersons/")
    public String findSportsByName() {
    /*
    Visualizar a las personas deportistas.
    Queremos que se vea un listado con el nombre y el apellido de la persona y el nombre del deporte que realiza
    (no es necesario que se vea la edad ni el nivel del deporte realizado).
    Para este punto es importante valerse de un DTO.
    */
        return null;
    }
}
