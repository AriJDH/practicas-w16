package com.bootcamp.literarias.controller;

import com.bootcamp.literarias.dto.ObraDto;
import com.bootcamp.literarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ObraController {

    @Autowired
    IObraService obraService;

    @PostMapping("")
    public ResponseEntity<ObraDto> create(@RequestBody ObraDto obraDto) {
        return new ResponseEntity<>(obraService.create(obraDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ObraDto>> getNombreAutor(@RequestParam("nombre") String nombre) {
        return new ResponseEntity<>(obraService.getNombreAutor(nombre), HttpStatus.OK);
    }
}
