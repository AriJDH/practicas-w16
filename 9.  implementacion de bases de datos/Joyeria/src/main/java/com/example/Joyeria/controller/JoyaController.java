package com.example.Joyeria.controller;

import com.example.Joyeria.dto.JoyaDTO;
import com.example.Joyeria.dto.MessageDTO;
import com.example.Joyeria.model.Joya;
import com.example.Joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaServ;

    @PostMapping("/jewelry/new")
    public ResponseEntity<MessageDTO> guardarJoya(@RequestBody Joya j){
        return new ResponseEntity<>(joyaServ.saveJoya(j), HttpStatus.OK);
    }

    @GetMapping("/jewelry")
    public ResponseEntity<List<JoyaDTO>> listadoJoyas(){
        return new ResponseEntity<>(joyaServ.getJoyas(), HttpStatus.OK);
    }

    @PostMapping("/jewelry/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJoya(@PathVariable int id){
        return new ResponseEntity<>(joyaServ.deleteJoya(id), HttpStatus.OK);
    }

    @PostMapping("/jewelry/update/{id_modificar}")
    public ResponseEntity<JoyaDTO> modificarJoya(@PathVariable int id_modificar, @RequestBody JoyaDTO joya){
        return new ResponseEntity<>(joyaServ.editJoya(id_modificar, joya), HttpStatus.OK);
    }
}
