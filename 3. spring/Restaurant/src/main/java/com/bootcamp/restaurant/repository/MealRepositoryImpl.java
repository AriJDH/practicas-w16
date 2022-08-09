package com.bootcamp.restaurant.repository;

import com.bootcamp.restaurant.entity.Ingredient;
import com.bootcamp.restaurant.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealRepositoryImpl implements IMealRepository{

    private List<Meal> meals = new ArrayList<>();

    @Autowired
    IngredientRepositoryImpl ingredientRepository;

    @Override
    public List<Meal> getAllMeals() {

        List<Ingredient> spaguettiIngredients = List.of(ingredientRepository.getAll().get(2), ingredientRepository.getAll().get(1));
        List<Ingredient> pizzaIngredients = List.of(ingredientRepository.getAll().get(3), ingredientRepository.getAll().get(5));
        List<Ingredient> soupIngredient = List.of(ingredientRepository.getAll().get(10), ingredientRepository.getAll().get(7));

        meals.add(new Meal("Spaguetti", spaguettiIngredients, 100.0));
        meals.add(new Meal("Pizza", pizzaIngredients, 75.0));
        meals.add(new Meal("Soup", soupIngredient, 40.0));

        return meals;
    }

    @Override
    public Meal getByNameWeight(String name, Double weight) {
        return getAllMeals().stream()
                .filter(meal -> meal.getName().equalsIgnoreCase(name))
                .filter(meal -> meal.getWeight().doubleValue() == weight )
                .findFirst().get();
    }
}
