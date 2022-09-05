package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.ClothesDto;
import com.bootcamp.showroom.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/clothes")
public class ClothesController {

    @Autowired
    private IClothesService clothesService;

    @PostMapping
    public ResponseEntity<ClothesDto> save(@RequestBody ClothesDto clothesDto) {
        return ResponseEntity.ok().body(clothesService.save(clothesDto));
    }

    @GetMapping
    public ResponseEntity<List<ClothesDto>> findAll(ClothesDto clothesDto) {
        return ResponseEntity.ok().body(clothesService.findAll(clothesDto));
    }

    @GetMapping("{code}")
    public ResponseEntity<ClothesDto> findByCode(@PathVariable String code) {
        return ResponseEntity.ok().body(clothesService.findByCode(code));
    }

    @GetMapping("size/{size}")
    public ResponseEntity<List<ClothesDto>> findBySize(@PathVariable String size) {
        return ResponseEntity.ok().body(clothesService.findBySize(size));
    }

    @PutMapping("{code}")
    public ResponseEntity<ClothesDto> updateByCode(@PathVariable String code, @RequestBody ClothesDto clothesDto) {
        return ResponseEntity.ok().body(clothesService.updateByCode(code, clothesDto));
    }

    @DeleteMapping("{code}")
    public ResponseEntity<?> delteByCode(@PathVariable String code) {
        clothesService.deleteByCode(code);
        return ResponseEntity.ok().body(null);
    }
}
