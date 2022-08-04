package com.example.starwars.Controller;

import com.example.starwars.DTO.StarWarsDTO;
import com.example.starwars.Service.IServiceStarwars;
import com.example.starwars.Service.ServiceStarwars;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StarWars")
public class Controller {
    private IServiceStarwars s;

    public Controller(IServiceStarwars service){
        this.s= service;
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<StarWarsDTO>> findPersonaje(@PathVariable String name){
        return new ResponseEntity<>(s.personajesPorNombre(name), HttpStatus.OK);
    }
}
