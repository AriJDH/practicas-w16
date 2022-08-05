package com.bootcamp.ejerciciorestaurante.service;

import com.bootcamp.ejerciciorestaurante.dto.IngredientsDto;
import com.bootcamp.ejerciciorestaurante.dto.RequestDto;
import com.bootcamp.ejerciciorestaurante.dto.ResponseDto;
import com.bootcamp.ejerciciorestaurante.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    @Autowired
    FoodRepository repo;


    public ResponseDto returnResponse(RequestDto request) {
        ResponseDto res = new ResponseDto();
        res.setTotalCalories(request.getIngredients().stream()
                .mapToInt(ingredientDish -> {
                    int calories = repo.getIngredients().stream()
                            .filter(ingredient -> ingredient.getName().equals(ingredientDish.getName()))
                            .findFirst()
                            .get()
                            .getCalories();
                    return ingredientDish.getGrams() * calories;
                })
                .sum());

//        List<IngredientsDto> listIngredients = request.getIngredients().stream()
//                .map(ingredients -> {
//                    IngredientsDto ing = new IngredientsDto();
//                    int calories = repo.getIngredients().stream()
//                            .filter(ingredient -> ingredient.getName().equals(ingredients))
//                            .findFirst()
//                            .get()
//                            .getCalories();
//                    ing.setName(ingredients);
//                    ing.setCalories(calories);
//                    return ing;
//                }).collect(Collectors.toList());
        List<IngredientsDto> listIngredients = request.getIngredients().stream()
                        .map(ingredients-> new IngredientsDto(ingredients.getName(),repo.getIngredients().stream()
                                .filter(ingredient -> ingredient.getName().equals(ingredients.getName()))
                                .findFirst()
                                .get().getCalories()))
                                .collect(Collectors.toList());



        res.setIngredientsDto(listIngredients);

        IngredientsDto maxCalories= listIngredients.stream()
                .max(Comparator.comparing(IngredientsDto::getCalories))
                .get();

        res.setMostCaloriesIngredient(maxCalories);
        return res;
    }

}
