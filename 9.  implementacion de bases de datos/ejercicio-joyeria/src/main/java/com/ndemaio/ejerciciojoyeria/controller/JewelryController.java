package com.ndemaio.ejerciciojoyeria.controller;

import com.ndemaio.ejerciciojoyeria.model.Jewelry;
import com.ndemaio.ejerciciojoyeria.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping (path = "/jewelry")
public class JewelryController {

    @Autowired
    private JewelryService jewelryService;

    @PostMapping (path = "/new")
    public ResponseEntity createJewelry(@RequestBody Jewelry jewelry) {
        Jewelry createdJewelry = jewelryService.create(jewelry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJewelry.getIdentifierNumber());
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(jewelryService.getAll());
    }

    @DeleteMapping (path = "/delete/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        jewelryService.removeJewelryById(id);
        return ResponseEntity.ok("Joya con ID " + id + " eliminada con éxito.");
    }

    @PutMapping (path = "/update/{id}")
    public ResponseEntity updateJewelry(@PathVariable int id, @RequestBody Jewelry updatedJewelry){
        Jewelry jewelry = jewelryService.update(id, updatedJewelry);
        return ResponseEntity.ok(jewelry);
    }



}
