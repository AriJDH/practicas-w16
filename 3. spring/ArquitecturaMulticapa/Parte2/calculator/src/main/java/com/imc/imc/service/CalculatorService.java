package com.imc.imc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.imc.imc.dto.Dish;
import com.imc.imc.dto.DishesDTO;
import com.imc.imc.dto.CalculatorResponseDTO;
import com.imc.imc.repository.IngredientRepository;
import com.imc.imc.dto.IngredientDTO;
import com.imc.imc.dto.MultipleDishesResponse;
import com.imc.imc.entity.IngredienteEntity;

@Service
public class CalculatorService {

    private final IngredientRepository ingredientRepository;

    public CalculatorService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public CalculatorResponseDTO dishCalculator(Dish dishRequest) {
        CalculatorResponseDTO calculatorResponseDTO = new CalculatorResponseDTO();

        // Time Complexity: O(n*m) -> n = number of ingredients in FoodRequest, m = number of ingredients in Repository
        List<IngredientDTO> ingredients = dishRequest.getIngredients().stream().map(
                ingredient -> {
                    IngredienteEntity ingredienteEntity = ingredientRepository.findByName(ingredient);
                    return new IngredientDTO(ingredienteEntity.getName(), ingredienteEntity.getCalories());
                }
        ).collect(Collectors.toList());
        

        int totalCalories = ingredients.stream().mapToInt(
                ingredient -> ingredient.getCalories() * dishRequest.getWeight()
        ).sum();

        IngredientDTO mostCaloricIngredient = ingredients.stream().max((i1, i2) -> i1.getCalories() - i2.getCalories()).get();

        //Fill the response
        calculatorResponseDTO.setCalories(totalCalories);
        calculatorResponseDTO.setIngredients(ingredients);
        calculatorResponseDTO.setMostCaloricIngredient(mostCaloricIngredient);
        calculatorResponseDTO.setWeight(dishRequest.getWeight());

        return calculatorResponseDTO;
    }
    
    public MultipleDishesResponse dishesCalculator(DishesDTO dishesRequest) {
        MultipleDishesResponse multipleDishesResponse = new MultipleDishesResponse();
        List<CalculatorResponseDTO> calculatorResponseDTOs = dishesRequest.getDishes().stream().map(
                dish -> dishCalculator(dish)
        ).collect(Collectors.toList());
        multipleDishesResponse.setData(calculatorResponseDTOs);

        return multipleDishesResponse;
    }

}
