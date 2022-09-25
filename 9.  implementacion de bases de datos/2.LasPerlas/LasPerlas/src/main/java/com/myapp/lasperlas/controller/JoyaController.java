package com.myapp.lasperlas.controller;

import com.myapp.lasperlas.dto.JoyaDTO;
import com.myapp.lasperlas.model.Joya;
import com.myapp.lasperlas.services.IJoyaService;
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
    public ResponseEntity<String> saveJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.saveJoya(joyaDTO), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<JoyaDTO>> getAllJoyas(){
        return new ResponseEntity<>(joyaService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJoya(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.updateJoya(id, joyaDTO), HttpStatus.OK);
    }


}
