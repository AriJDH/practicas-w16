package com.bootcamp.ejerciciospracticosp2vivo.repository;

import com.bootcamp.ejerciciospracticosp2vivo.entity.Ingredient;
import com.bootcamp.ejerciciospracticosp2vivo.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealRepository implements IMealRepository {

    private List<Meal> meals = new ArrayList<>();

    @Autowired
    IngredientRepository ingredientRepository;




    @Override
    public List<Meal> getAllMeal() {
        List<Ingredient> bean = List.of(ingredientRepository.getAll().get(2), ingredientRepository.getAll().get(1));
        List<Ingredient> egg = List.of(ingredientRepository.getAll().get(3), ingredientRepository.getAll().get(5));
        List<Ingredient> potatoChorreada = List.of(ingredientRepository.getAll().get(10), ingredientRepository.getAll().get(7));

        meals.add(new Meal("Bean", bean, 20.0));
        meals.add(new Meal("Egg", egg, 12.0));
        meals.add(new Meal("PotatoChorreada", potatoChorreada, 500.0));
        return meals;
    }

    @Override
    public Meal getByNameWeight(String name, Double weight) {
        return meals.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .filter(y -> y.getWeight().doubleValue() == weight)
                .findFirst().get();
    }
}
