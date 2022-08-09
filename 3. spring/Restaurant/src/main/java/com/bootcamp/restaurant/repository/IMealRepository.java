package com.bootcamp.restaurant.repository;

import com.bootcamp.restaurant.entity.Meal;

import java.util.List;

public interface IMealRepository {

    List<Meal> getAllMeals();
    Meal getByNameWeight(String name, Double weight);

}
