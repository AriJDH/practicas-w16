package com.curso.servicioproductos.controller;

import com.curso.servicioproductos.models.entity.Product;
import com.curso.servicioproductos.models.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private IProductService iProductService;

  @GetMapping("/findAll")
  public ResponseEntity<List<Product>> productList(){
    return ResponseEntity.ok(iProductService.findAll());
  }

  @GetMapping("/findByName/{id}")
  public ResponseEntity<Product> details(@PathVariable Long id){
    return ResponseEntity.ok(iProductService.findById(id));
  }
}
