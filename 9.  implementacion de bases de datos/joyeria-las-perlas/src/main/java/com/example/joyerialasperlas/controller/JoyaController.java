package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Ejercicio > Modulo 18: Implementacion de base de datos > CRUDConJPA
 * ESTADO: Finalizado.
 * COMENTARIOS: en el ejercicio se usa MySQL como BDD. Ver archivo '.../resources/application.properties'.
 * @GonzaloNahuelDiPierro
 * */
@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody Joya joya) {
        Long nroIdentificatorio = this.joyaService.create(joya);
        return new ResponseEntity<>("Nro identificatorio: " + nroIdentificatorio, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Joya>> getAll() {
        return new ResponseEntity<>(this.joyaService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.joyaService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<Joya> update(@PathVariable Long id_modificar, @RequestBody Joya joya) {
        joya.setId(id_modificar);
        return new ResponseEntity<>(this.joyaService.update(joya), HttpStatus.OK);
    }
}
