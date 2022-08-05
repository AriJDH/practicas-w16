package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.entity.Dish;
import com.bootcamp.calorias.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepository implements IRepository<Dish> {
    private final IngredientRepository ingredientRepository;
    private List<Dish> dishes;

    private int getRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));

    }

    private void initializeRepo() {
        List<Ingredient> ingredients = this.ingredientRepository.getAll();
        for (int i = 0; i < 20; i++) {
            this.dishes.add(
                    new Dish(
                            "Plato " + (i + 1),
                            Arrays.asList(
                                    ingredients.get(getRandomNumber(0, ingredients.size() - 1)),
                                    ingredients.get(getRandomNumber(0, ingredients.size() - 1)),
                                    ingredients.get(getRandomNumber(0, ingredients.size() - 1))
                            ),
                            20d
                    )
            );
        }
    }

    public DishRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.dishes = new ArrayList<>();
        initializeRepo();
    }

    public List<Dish> getAll() {
        return this.dishes;
    }
}
