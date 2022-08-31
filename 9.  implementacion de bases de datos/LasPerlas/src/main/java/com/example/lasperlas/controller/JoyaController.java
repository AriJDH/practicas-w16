package com.example.lasperlas.controller;

import com.example.lasperlas.dtos.JoyaDto;
import com.example.lasperlas.dtos.MessageDto;
import com.example.lasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<MessageDto> saveJoya(@RequestBody JoyaDto joyaDTO){
        return new ResponseEntity<>(joyaService.saveJoya(joyaDTO), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<JoyaDto>> getAllJoyas(){
        return new ResponseEntity<>(joyaService.getJoyas(), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<MessageDto> deleteJoya(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateJoya(@PathVariable Long id, @RequestBody JoyaDto joyaDTO){
        return new ResponseEntity<>(joyaService.updateJoya(id, joyaDTO), HttpStatus.OK);
    }

}
