package com.bootcamp.ejerciciospracticosp2vivo.service;

import com.bootcamp.ejerciciospracticosp2vivo.dto.MealDto;
import com.bootcamp.ejerciciospracticosp2vivo.dto.MealDtoRequest;
import com.bootcamp.ejerciciospracticosp2vivo.entity.Ingredient;
import com.bootcamp.ejerciciospracticosp2vivo.entity.Meal;
import com.bootcamp.ejerciciospracticosp2vivo.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService implements IMealService{
   @Autowired
    MealRepository mealRepository;

    @Override
    public MealDto getMealByNameWeight(String name, Double weight) {
        Meal meal = mealRepository.getByNameWeight(name, weight);

        Double totalCalories = meal.getIngredients().stream()
                .mapToDouble(Ingredient::getCalories).sum();

        List<Ingredient> ingredientsHighestCalories = meal.getIngredients().stream()
                .sorted(Comparator.comparing(Ingredient::getCalories))
                .collect(Collectors.toList());

        String nameIngredient = ingredientsHighestCalories.get(ingredientsHighestCalories.size()-1).getName();

        return new MealDto(meal.getName(), totalCalories, ingredientsHighestCalories,nameIngredient);
    }

    @Override
    public List<MealDto> getMeals(List<MealDtoRequest> mealDtoRequests) {
        return mealDtoRequests.stream()
                .map(x -> getMealByNameWeight(x.getName(), x.getWeight()))
                .collect(Collectors.toList());
    }
}
