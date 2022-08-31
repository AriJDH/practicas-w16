package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.JoyaDto;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController()
public class JoyaController {
    @Autowired
    IJoyaService service;

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoya()
    {
        return new ResponseEntity<>(service.getJoyas(), HttpStatus.OK);
    }
    @PostMapping("/jewerly/new")
    public ResponseEntity<Joya> createJoya(@RequestBody @Valid JoyaDto dto)
    {
        service.saveJoya(dto);
        return  new ResponseEntity<>(null, HttpStatus.OK);
    }
    @GetMapping("/jewerly/delete/{id}")
    public ResponseEntity<List<Joya>> getJoya(@RequestParam Long id)
    {
        service.deleteJoyaBy(id);
        return new ResponseEntity<>(service.getJoyas(), HttpStatus.OK);
    }
    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<Joya> updateJoya(@RequestParam Long id, @RequestBody @Valid JoyaDto dto)
    {
        return new ResponseEntity<>(service.UpdateJoyaById(id, dto), HttpStatus.OK);

    }
}
