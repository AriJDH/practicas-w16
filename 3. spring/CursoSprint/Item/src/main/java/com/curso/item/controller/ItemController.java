package com.curso.item.controller;

import com.curso.item.model.Item;
import com.curso.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

  @Autowired
  private IItemService iItemService;

  @GetMapping("/findAll")
  public ResponseEntity<List<Item>> findAll(){
    return ResponseEntity.ok(iItemService.findAll());
  }

  @GetMapping("/see/{id}/quantity/{quantity}")
  public ResponseEntity<Item> details(@PathVariable Long id, @PathVariable Integer quantity) {
    return ResponseEntity.ok(iItemService.findById(id, quantity));
  }
}
