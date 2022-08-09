package com.calculadora.calorias.repository;

import com.calculadora.calorias.entity.FoodMenu;

public interface IRestaurantRepository {
    FoodMenu findByName(String name);
}
