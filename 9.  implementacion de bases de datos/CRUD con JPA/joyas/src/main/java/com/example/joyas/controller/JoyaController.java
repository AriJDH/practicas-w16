package com.example.joyas.controller;

import com.example.joyas.dto.JoyaDto;
import com.example.joyas.dto.MensajeDto;
import com.example.joyas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
        public ResponseEntity<MensajeDto> createJewerly(@RequestBody JoyaDto joyadto){
        return new ResponseEntity<>(joyaService.saveJewerly(joyadto), HttpStatus.CREATED);
    }

    @GetMapping("/")
        public ResponseEntity<List<JoyaDto>> getAllJewerly(){
        List<JoyaDto> joyas = joyaService.getAllJewerly();
        return new ResponseEntity<>(joyas,HttpStatus.FOUND);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id){
        joyaService.deleteJewerly(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDto> updateJewerly(@RequestBody JoyaDto joyaDto,@PathVariable Long id_modificar){
        return new ResponseEntity<>(joyaService.updateJoya(joyaDto,id_modificar),HttpStatus.ACCEPTED);
    }
}
