package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.CalorieDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;
import com.example.calculadoracalorias.entity.Ingredient;
import com.example.calculadoracalorias.entity.Dish;
import com.example.calculadoracalorias.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculatorService {

    private CalculatorRepository repository;
    public CalculatorService(CalculatorRepository repository){
        this.repository = repository;
    }


    public CalorieDTO getCalories(String dish){
        List<Dish> dishes = repository.getDishes();
        Dish foundDish = dishes.stream()
                .filter(x -> x.getName().equals(dish))
                .findFirst()
                .orElse(null);
        if(foundDish == null){
            CalorieDTO calorieDto = new CalorieDTO(0);
            return calorieDto;
        }
        return new CalorieDTO(foundDish.getIngredients().stream().mapToInt(Ingredient::getCalories).sum()) ;
    }

    public List<IngredientDTO> getDishIngredients(String dish) {
        List<Dish> dishes = repository.getDishes();
        Dish foundDish = dishes.stream()
                .filter(x -> x.getName().equals(dish))
                .findFirst()
                .orElse(null);
        if( foundDish == null){
            return new ArrayList<>();
        }
        return foundDish.getIngredients().stream()
                .map(ingredient -> new IngredientDTO(ingredient.getName(), ingredient.getCalories()))
                .collect(Collectors.toList());
    }

    public IngredientDTO getMoreCaloricIngredient(String dish){
        List<Dish> dishesList = repository.getDishes();
        Dish foundDish = dishesList.stream()
                .filter(x -> x.getName().equals(dish))
                .findFirst()
                .orElse(null);
        if( foundDish == null){
            return null;
        }
        Ingredient ingredient = foundDish.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).orElse(null);
        return ingredient != null ? new IngredientDTO(ingredient.getName(), ingredient.getCalories()) : null;
    }
}
