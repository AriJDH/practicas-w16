package com.ndemaio.ejerciciocalculadoradecalorias.service;

import com.ndemaio.ejerciciocalculadoradecalorias.dto.MealDataRequest;
import com.ndemaio.ejerciciocalculadoradecalorias.dto.MealDTO;
import com.ndemaio.ejerciciocalculadoradecalorias.entity.Meal;
import com.ndemaio.ejerciciocalculadoradecalorias.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public MealDTO getMealNamed(String name, Float weight) throws MealNotFoundException {
        Meal meal = mealRepository.getMealByName(name).orElseThrow(() -> new MealNotFoundException("No existe un plato con el nombre dado."));
        MealDTO mealDTO = new MealDTO(meal.totalCalories(), meal.getIngredients(), meal.maxCaloriesIngredient());
        return mealDTO;
    }

    public List<Meal> getMeals() {
        return mealRepository.getAll();
    }

    public void addMeal(Meal meal) {
        mealRepository.add(meal);
    }

    public List<MealDTO> getInformationFor(List<MealDataRequest> mealDataRequests) {
        return mealDataRequests.stream().map(request -> {
            try {
                return getMealNamed(request.getName(), request.getWeight());
            } catch (MealNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
