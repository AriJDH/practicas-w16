package com.curso.item.client;

import com.curso.item.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface IProductClient {

  @GetMapping("/product/findAll")
  List<Product> findAll();

  @GetMapping("/product//findByName/{id}")
  Product findById(@PathVariable Long id);

}
