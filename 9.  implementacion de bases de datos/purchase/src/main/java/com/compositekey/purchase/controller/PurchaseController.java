package com.compositekey.purchase.controller;

import com.compositekey.purchase.DTO.PurchaseDto;
import com.compositekey.purchase.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class PurchaseController {

    @Autowired
    IPurchaseService purchaseService;

    @PostMapping("/new")
    public ResponseEntity<PurchaseDto> create(@RequestBody PurchaseDto purchaseCreateDTO) {
        PurchaseDto response = purchaseService.create(purchaseCreateDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/find/{client_id}/{date_purchase}")
    public ResponseEntity<PurchaseDto> findById(@PathVariable Integer client_id, @PathVariable String date_purchase) {
        PurchaseDto response = purchaseService.getById(client_id, date_purchase);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
