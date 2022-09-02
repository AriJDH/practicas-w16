package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.JoyaDTO;
import com.bootcamp.joyeria.entity.Joya;
import com.bootcamp.joyeria.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private JoyaService joyaService;

    @PostMapping("new")
    public ResponseEntity<Integer> createJewerly(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.saveJewerly(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JoyaDTO>> findAllJewerly(){
        return new ResponseEntity<>(joyaService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Integer id){
        joyaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<JoyaDTO> deleteJewerly(@PathVariable Integer id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.updateById(id, joyaDTO), HttpStatus.OK);
    }
}
