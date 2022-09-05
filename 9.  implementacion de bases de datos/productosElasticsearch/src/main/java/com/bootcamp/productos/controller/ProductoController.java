package com.bootcamp.productos.controller;

import com.bootcamp.productos.dto.ProductoDto;
import com.bootcamp.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @PostMapping("")
    public ResponseEntity<ProductoDto> create(@RequestBody ProductoDto productoDto) {
        return new ResponseEntity<>(productoService.create(productoDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductoDto>> getAll() {
        return new ResponseEntity<>(productoService.getProducts(), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> delete(@RequestParam("id") String id) {
        return new ResponseEntity<>(productoService.delete(id), HttpStatus.OK);
    }
}
