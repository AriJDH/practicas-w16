package com.ndemaio.ejerciciocalculadoradecalorias.repository;

import com.ndemaio.ejerciciocalculadoradecalorias.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {

    private final List<Food> availableFood;

    public FoodRepository() {
        availableFood = new ArrayList<>();
    }

    public void save(List<Food> foodList) {
        availableFood.addAll(foodList);
    }

    public List<Food> getAll() {
        return availableFood;
    }

}
