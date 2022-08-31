package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.JoyaUpdateDTO;
import com.example.joyeria.exceptions.IdError;
import com.example.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    final JoyaService joyaService;

    public JoyaController(JoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createNewJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.createNewJoya(joyaDTO), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<JoyaUpdateDTO>> getAll(){
        return new ResponseEntity<>(joyaService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> getById(@PathVariable int id) throws IdError {
        return new ResponseEntity<>(joyaService.deleteById(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaUpdateDTO> updateJoya(@PathVariable int id_modificar, @RequestBody JoyaUpdateDTO joyaDTO) throws IdError {
        return new ResponseEntity<>(joyaService.updateById(id_modificar,joyaDTO), HttpStatus.OK);
    }

}
