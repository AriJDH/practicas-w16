package com.example.arquitecturamulticapa.Controller;

import com.example.arquitecturamulticapa.DTO.CharacterDTO;
import com.example.arquitecturamulticapa.Entity.Character;
import com.example.arquitecturamulticapa.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CharacterController {
    @Autowired //singleton!
    private CharacterService characterService;
    @GetMapping("/character")
    public ResponseEntity<List<CharacterDTO>> getCharacters() {
        return new ResponseEntity<>(this.characterService.getCharacters(), HttpStatus.OK);
    }

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDTO>> searchByName(@PathVariable String name) {
        return new ResponseEntity<>(this.characterService.searchByName(name), HttpStatus.OK);
    }
    @PostMapping("/character") //ahora vemos como agregar
    public ResponseEntity addCharacters(@RequestBody List<Character> characters) {
        this.characterService.addCharacters(characters);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
