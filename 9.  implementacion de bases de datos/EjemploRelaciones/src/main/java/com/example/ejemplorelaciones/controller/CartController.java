package com.example.ejemplorelaciones.controller;

import com.example.ejemplorelaciones.dto.CartDto;
import com.example.ejemplorelaciones.services.CartService;
import com.example.ejemplorelaciones.services.iCartService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private iCartService cartService;

    public CartController(CartService cartService){
        this.cartService=cartService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> newCart(@RequestBody CartDto cartDto){
        return ResponseEntity.ok().body(cartService.save(cartDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.delete(id);
    }
}
