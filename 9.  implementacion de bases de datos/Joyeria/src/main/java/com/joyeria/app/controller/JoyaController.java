package com.joyeria.app.controller;

import com.joyeria.app.dto.JoyaDto;
import com.joyeria.app.model.Joya;
import com.joyeria.app.service.IJoyaService;
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
    public ResponseEntity<JoyaDto> save(@RequestBody Joya joya){
        return new ResponseEntity<>(joyaService.save(joya), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDto>> getAllJewerlys(){
        return new ResponseEntity<>(joyaService.getJoyas(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletJewerly(@PathVariable Long id) throws Exception {
        joyaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDto> getJewerly(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.getJoyaById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDto> updateJewerly(@PathVariable Long id_modificar,@RequestBody Joya joya) throws Exception {
        return new ResponseEntity<>(joyaService.update(id_modificar,joya), HttpStatus.OK);
    }




}
