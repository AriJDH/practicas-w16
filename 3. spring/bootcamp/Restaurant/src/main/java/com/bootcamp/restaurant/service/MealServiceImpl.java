package com.bootcamp.restaurant.service;

import com.bootcamp.restaurant.dto.MealDto;
import com.bootcamp.restaurant.dto.MealDtoRequest;
import com.bootcamp.restaurant.entity.Ingredient;
import com.bootcamp.restaurant.entity.Meal;
import com.bootcamp.restaurant.repository.MealRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements IMealService{

    @Autowired
    MealRepositoryImpl mealRepository;

    @Override
    public MealDto getMealByNameWeight(String name, Double weight) {

        Meal meal = mealRepository.getByNameWeight(name, weight);

        Double totalCalories = meal.getIngredients().stream()
                .mapToDouble(Ingredient::getCalories).sum();

        List<Ingredient> ingredientHighestCalories = meal.getIngredients().stream()
                .sorted(Comparator.comparing(Ingredient::getCalories))
                .collect(Collectors.toList());

        String nameIngredient = ingredientHighestCalories.get(ingredientHighestCalories.size()-1).getName();

        return new MealDto( meal.getName(), totalCalories.intValue(), meal.getIngredients(), nameIngredient);
    }

    @Override
    public List<MealDto> getMeals(List<MealDtoRequest> mealRequest) {

       return mealRequest.stream()
               .map(mealDtoRequest -> getMealByNameWeight(mealDtoRequest.getName(), mealDtoRequest.getWeight()))
               .collect(Collectors.toList());

    }
}
