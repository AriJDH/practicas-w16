package com.example.lasPerlas.controller;

import com.example.lasPerlas.dto.JoyaDTO;
import com.example.lasPerlas.service.IJoyeriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewely")
public class JoyeriaController {

    @Autowired
    private IJoyeriaService joyeriaService;


    @PostMapping("/new")
    public ResponseEntity<Long> create(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok().body(joyeriaService.createJoya(joyaDTO).getNro_identificatorio());
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDTO>> findAll(){
        return ResponseEntity.ok().body(joyeriaService.find());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(joyeriaService.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody JoyaDTO joyaDTO,@PathVariable Long id){
        return new ResponseEntity<>(joyeriaService.updateJoya(id,joyaDTO),HttpStatus.OK);
    }


}
