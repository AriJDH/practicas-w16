package com.ndemaio.ejerciciocalculadoradecalorias.repository;

import com.ndemaio.ejerciciocalculadoradecalorias.entity.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MealRepository {

    private final List<Meal> meals;

    public MealRepository() {
        this.meals = new ArrayList<>();
    }

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAll() {
        return meals;
    }

    public Optional<Meal> getMealByName(String name) {
        return meals.stream().filter(meal -> meal.getName().equals(name)).findFirst();
    }
}
