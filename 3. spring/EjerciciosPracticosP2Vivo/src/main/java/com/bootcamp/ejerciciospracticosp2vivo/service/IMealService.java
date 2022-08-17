package com.bootcamp.ejerciciospracticosp2vivo.service;

import com.bootcamp.ejerciciospracticosp2vivo.dto.MealDto;
import com.bootcamp.ejerciciospracticosp2vivo.dto.MealDtoRequest;

import java.util.List;

public interface IMealService {
    MealDto getMealByNameWeight(String name, Double weight);
    List<MealDto> getMeals(List<MealDtoRequest> mealDtoRequests);
}
