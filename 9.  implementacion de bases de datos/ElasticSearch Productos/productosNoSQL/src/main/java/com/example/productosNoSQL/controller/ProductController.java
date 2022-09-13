package com.example.productosNoSQL.controller;

import com.example.productosNoSQL.dto.ProductDto;
import com.example.productosNoSQL.dto.StatusDto;
import com.example.productosNoSQL.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StatusDto> createProducts(@RequestBody List<ProductDto> productDtoList){
        return new ResponseEntity<>(productService.createProduct(productDtoList),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updatedProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.updatedProduct(productDto),HttpStatus.ACCEPTED);
    }


}
