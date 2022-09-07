package com.bootcamp.aplication.controller;

import com.bootcamp.aplication.dto.SWCharacterDTO;
import com.bootcamp.aplication.entity.SWCharacter;
import com.bootcamp.aplication.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    StarWarsService starWarsService;

    @GetMapping("/characters")
    public ResponseEntity<List<SWCharacter>> getData() {

        return ResponseEntity.ok()
                .body(starWarsService.getDataCharacters());
    }

    @GetMapping("/characters/{text}")
    public ResponseEntity<List<SWCharacterDTO>> findCharacterContains(@PathVariable String text) {

        try {
            return ResponseEntity.ok()
                    .body(starWarsService.findCharacter(text));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ArrayList<>());
        }
    }

}
