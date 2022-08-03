package com.ndemaio.ejerciciodeportistas.controller;

import com.ndemaio.ejerciciodeportistas.entity.Sport;
import com.ndemaio.ejerciciodeportistas.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    private final SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }


    @GetMapping (path = "/findSports")
    public List<Sport> getSports() {
        return sportService.findAll();
    }

    @GetMapping (path = "/findSport/{name}")
    public ResponseEntity<?> getSportByName(@PathVariable String name) {
        try {
            var sport = sportService.findByName(name);
            return ResponseEntity.ok(sport.getLevel());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No existe deporte con el nombre dado.");
        }
    }
}
