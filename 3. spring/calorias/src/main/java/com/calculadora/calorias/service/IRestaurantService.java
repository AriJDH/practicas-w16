package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.FoodMenuDTO;

public interface IRestaurantService {
    FoodMenuDTO findByName(String name, Double weight);
}
