package com.example.apistarwars.Controller;

import com.example.apistarwars.Dto.CharacterDTO;
import com.example.apistarwars.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("")
    public ResponseEntity<List<CharacterDTO>> getAllCharacter(){

        return new ResponseEntity<>( characterService.getAllCharacter(),HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacterByName(@PathVariable String name){
        return new ResponseEntity<>(characterService.getCharacterByName(name), HttpStatus.OK);
    }

}
