package com.curso.item.service;

import com.curso.item.model.Item;

import java.util.List;

public interface IItemService {

  List<Item>findAll();
  Item findById(Long id, Integer quantity);
}
