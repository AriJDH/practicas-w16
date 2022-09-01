package com.curso.item.service;

import com.curso.item.model.Item;
import com.curso.item.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements IItemService {

  @Autowired
  private RestTemplate clientRest;


  @Override
  public List<Item> findAll() {
    List<Product> products = Arrays.asList(clientRest.getForObject("http://localhost:9090/product/findAll", Product[].class));
    return products.stream().map(x -> new Item(x, 1)).collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    Map<String, String> pathVariable = new HashMap<String, String>();
    pathVariable.put("id", id.toString());
    Product product = clientRest.getForObject("http://localhost:9090/product/findByName/{id}", Product.class, pathVariable);
    return new Item(product, quantity);
  }
}
