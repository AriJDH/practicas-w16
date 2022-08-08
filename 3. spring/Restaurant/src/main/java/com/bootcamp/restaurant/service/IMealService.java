package com.bootcamp.restaurant.service;

import com.bootcamp.restaurant.dto.MealDto;
import com.bootcamp.restaurant.dto.MealDtoRequest;

import java.util.List;

public interface IMealService {

   MealDto getMealByNameWeight(String name, Double weight);

   List<MealDto> getMeals(List<MealDtoRequest> mealRequest);
}
