package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.SaleDto;
import com.bootcamp.showroom.dto.SaleFilterDto;
import com.bootcamp.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDto> save(@RequestBody SaleDto saleDto){
        return ResponseEntity.ok().body(saleService.save(saleDto));
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> findAll(SaleFilterDto saleDto){
        return ResponseEntity.ok().body(saleService.findAll(saleDto));
    }

    @GetMapping("{number}")
    public ResponseEntity<SaleDto> findByNumber(@PathVariable Long number){
        return ResponseEntity.ok().body(saleService.findByNumber(number));
    }

    @GetMapping("clothes/{number}")
    public ResponseEntity<SaleDto> findAllClothesBySaleNumber(@PathVariable Long number){
        return ResponseEntity.ok().body(saleService.findAllClothesBySaleNumber(number));
    }

    @PutMapping("{number}")
    public ResponseEntity<SaleDto> updateByNumber(@PathVariable Long number, @RequestBody SaleDto saleDto){
        return ResponseEntity.ok().body(saleService.updateByNumber(number, saleDto));
    }

    @DeleteMapping("{number}")
    public ResponseEntity<?> delteByCode(@PathVariable Long number){
        saleService.deleteByNumber(number);
        return ResponseEntity.ok().body(null);
    }
}
