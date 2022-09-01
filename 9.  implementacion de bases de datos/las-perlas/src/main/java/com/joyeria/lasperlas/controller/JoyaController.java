package com.joyeria.lasperlas.controller;

import com.joyeria.lasperlas.DTOs.JoyaDTO;
import com.joyeria.lasperlas.DTOs.JoyaUpdateDTO;
import com.joyeria.lasperlas.service.IJoyaService;
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

    @GetMapping("/find")
    public ResponseEntity<List<JoyaDTO>> getAll(){
        return new ResponseEntity<>(joyaService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JoyaDTO> delete(@PathVariable Long id){
        joyaService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Long> create(@RequestBody JoyaDTO joyaDTO) {
        Long result = joyaService.create(joyaDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaUpdateDTO> update(@RequestBody JoyaDTO joyaDTO, @PathVariable Long id) {
        JoyaUpdateDTO result = joyaService.update(joyaDTO, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
