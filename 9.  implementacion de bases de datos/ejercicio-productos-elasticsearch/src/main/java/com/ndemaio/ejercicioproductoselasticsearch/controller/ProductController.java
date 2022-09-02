package com.ndemaio.ejercicioproductoselasticsearch.controller;

import com.ndemaio.ejercicioproductoselasticsearch.model.Product;
import com.ndemaio.ejercicioproductoselasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // add, update, get, delete, getall
    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added");
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity getProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id) {
        productService.updateProductWithId(id, updatedProduct);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Updated product"));
    }

}
