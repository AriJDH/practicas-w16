package com.example.lasperlas.controller;

import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    IJoyaService service;

    public JoyaController(IJoyaService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaDto> crearJoya(@RequestBody JoyaDto joya) {
        return new ResponseEntity<>(service.create(joya), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JoyaDto>> listarJoyas() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarJoya(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDto> actualizarJoya(@PathVariable Long id, @RequestBody JoyaDto joya) {
        return new ResponseEntity<>(service.update(joya, id), HttpStatus.OK);
    }
}
