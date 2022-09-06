package com.bootcamp.elsproductos.controller;

import com.bootcamp.elsproductos.model.Product;
import com.bootcamp.elsproductos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // add, update, get, delete, getall
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity(productService.getProducts(),HttpStatus.OK);
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id) {
        productService.updateProduct(id, updatedProduct);
        return new ResponseEntity(HttpStatus.OK);
    }

}