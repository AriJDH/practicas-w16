package com.example.sports.controller;

import com.example.sports.dto.response.SportDTO;
import com.example.sports.dto.response.SportLevelDTO;
import com.example.sports.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportController {
    @Autowired
    private SportService sportService;
    @GetMapping("/")
    public ResponseEntity<List<SportDTO>> findSports() {
        return new ResponseEntity<>(this.sportService.findALl(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SportLevelDTO> findSportsByName(@PathVariable String name) {
        return new ResponseEntity<>(this.sportService.findByName(name), HttpStatus.OK);
    }
}
