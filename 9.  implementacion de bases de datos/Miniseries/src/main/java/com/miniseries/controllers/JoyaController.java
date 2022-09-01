package com.miniseries.controllers;

import com.miniseries.dto.JoyaDTO;
import com.miniseries.services.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<Long> create(@RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>(joyaService.create(joyaDTO).getId(),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(joyaService.find(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.delete(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody JoyaDTO joyaDTO, @PathVariable Long id) {
        return new ResponseEntity<>(joyaService.update(id,joyaDTO), HttpStatus.OK);
    }

}
