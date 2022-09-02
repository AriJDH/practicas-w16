package com.example.practicajoyeria.controller;

import com.example.practicajoyeria.dto.JewelryDTO;
import com.example.practicajoyeria.dto.JewelryResponseDTO;
import com.example.practicajoyeria.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jewelry")
public class JewelryController {

    IJewelryService jewelryService;

    @Autowired
    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<JewelryResponseDTO> createJewelry(@RequestBody JewelryDTO jewelryDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(jewelryService.saveJewelry(jewelryDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<JewelryResponseDTO> getJewelry(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(jewelryService.findJewelryById(id));
    }
}
