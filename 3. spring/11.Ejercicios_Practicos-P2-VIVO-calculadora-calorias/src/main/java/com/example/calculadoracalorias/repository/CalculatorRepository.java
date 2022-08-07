package com.example.calculadoracalorias.repository;


import com.example.calculadoracalorias.entity.Ingredient;
import com.example.calculadoracalorias.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CalculatorRepository {

    private List<Dish> dishes;
    private List<Ingredient> ingredients;
    private ParseJson parse = new ParseJson();

    public CalculatorRepository() {
        this.ingredients = parse.goUpIngredients();
        this.dishes = goUpDishes();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Dish> goUpDishes() {
        List<Dish> dishes = new ArrayList<>();

        dishes.add(new Dish("Premium", 230.0, randomIngredients()));
        dishes.add(new Dish("Basic", 300.0, randomIngredients()));
        dishes.add(new Dish("Standard", 260.0, randomIngredients()));

        return dishes;
    }

    public List<Dish> getDishes(){
        return dishes;
    }

    public List<Ingredient> randomIngredients() {
        List<Ingredient> ingredients = getIngredients();
        List<Ingredient> recipes = new ArrayList<>();
        Random difNumber = new Random();
        recipes.add(ingredients.get(difNumber.nextInt(ingredients.size())));
        recipes.add(ingredients.get(difNumber.nextInt(ingredients.size())));
        recipes.add(ingredients.get(difNumber.nextInt(ingredients.size())));
        return recipes;
    }
}
