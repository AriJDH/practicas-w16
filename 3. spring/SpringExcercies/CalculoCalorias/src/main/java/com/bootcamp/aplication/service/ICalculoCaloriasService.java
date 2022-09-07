package com.bootcamp.aplication.service;

import com.bootcamp.aplication.dto.OrderDTO;
import com.bootcamp.aplication.dto.ResponseDTO;
import com.bootcamp.aplication.entity.Food;

import java.util.List;

public interface ICalculoCaloriasService {

    List<Food> findAllFood();

    Food findFood(String s);

    List<ResponseDTO> caloriesCalculate(List<OrderDTO> pedido);
}
