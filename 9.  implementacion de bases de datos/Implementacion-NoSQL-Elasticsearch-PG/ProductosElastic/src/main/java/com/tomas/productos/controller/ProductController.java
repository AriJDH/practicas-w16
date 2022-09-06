package com.tomas.productos.controller;

import com.tomas.productos.dto.CreateProductDTO;
import com.tomas.productos.dto.MessageDTO;
import com.tomas.productos.dto.ProductDTO;
import com.tomas.productos.dto.UpdateProductDto;
import com.tomas.productos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("save")
    public ResponseEntity<CreateProductDTO> saveProduct(@RequestBody ProductDTO productDto){

        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);

    }

    @PutMapping("update")
    public ResponseEntity<MessageDTO> updateProduct(@RequestBody UpdateProductDto updateProductDto){

        return new ResponseEntity<>(productService.updateProduct(updateProductDto), HttpStatus.OK);

    }

}
