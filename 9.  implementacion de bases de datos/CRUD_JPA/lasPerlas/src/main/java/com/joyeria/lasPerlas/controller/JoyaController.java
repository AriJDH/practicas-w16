package com.joyeria.lasPerlas.controller;

import com.joyeria.lasPerlas.service.IJoyaService;
import com.joyeria.lasPerlas.model.Joya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    IJoyaService iJoyaService;

    @PostMapping("/new")
    public ResponseEntity<String> createJoya(@RequestBody Joya joya){
        Long id = iJoyaService.saveJoya(joya);
        return new ResponseEntity<>("Se ha añadido la joya correctamente con id "+id, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Joya> getJoyas(){
        return iJoyaService.getJoyas();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id){
        iJoyaService.deleteJoya(id);
        return new ResponseEntity<>("La joya se ha eliminado correctamente", HttpStatus.OK);
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<Joya> uptadeJoya(@PathVariable Long id_modificar,
                            @RequestParam String nombre,
                           @RequestParam String material,
                           @RequestParam Double gramos,
                           @RequestParam String particularidad,
                           @RequestParam Boolean posee_piedra){
       return new ResponseEntity<>(iJoyaService.updateJoya(id_modificar,nombre,material,gramos,particularidad,posee_piedra), HttpStatus.OK);
    }
}
