package com.emeli.showroom.controller;

import com.emeli.showroom.dto.ClothingDto;
import com.emeli.showroom.service.ICLothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothingController {

    @Autowired
    private ICLothingService cLothingService;

    @PostMapping
    public ResponseEntity<ClothingDto> saveClothing(@RequestBody ClothingDto clothingDto) {
        return new ResponseEntity<>(cLothingService.saveClothing(clothingDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClothingDto>> getClothing(@RequestParam(required = false, value = "name") String name) {
        if (name != null) {
            return new ResponseEntity<>(cLothingService.findClothingByName(name), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cLothingService.getClothing(), HttpStatus.OK);
        }
    }

    @GetMapping("/{code:[\\d]+}")
    public ResponseEntity<ClothingDto> findClothing(@PathVariable Long code) {
        return new ResponseEntity<>(cLothingService.findClothing(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothingDto> updateClothing(@RequestBody ClothingDto clothingDto) {
        return new ResponseEntity<>(cLothingService.updateClothing(clothingDto), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteClothingById(@PathVariable Long code) {
        cLothingService.deleteClothingById(code);
        return new ResponseEntity<>("Se elimino satisfactoriamente", HttpStatus.OK);
    }

    @GetMapping("/{size:[a-zA-Z]+}")
    public ResponseEntity<List<ClothingDto>> findClothingBySize(@PathVariable String size) {
        return new ResponseEntity<>(cLothingService.findClothingBySize(size), HttpStatus.OK);
    }
}
