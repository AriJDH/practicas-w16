package com.restaurante.calorias.service;

import com.restaurante.calorias.dto.DishDTO;
import com.restaurante.calorias.dto.DishResponseDTO;
import com.restaurante.calorias.dto.IngredientDTO;
import com.restaurante.calorias.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService{

    private final IngredientRepository ingredientRepository;

    public DishServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public DishResponseDTO getCalories(DishDTO dish) {
        Integer calories = dish.getIngredients().stream().map(d->d.getCalories()).reduce(0,Integer::sum);
        DishResponseDTO dishResponseDTO = new DishResponseDTO(dish);
        dishResponseDTO.setCalories(calories);
        //dishResponseDTO.setIngredients(dish.getIngredients().stream().sorted(Comparator.comparingInt(IngredientDTO::getCalories)).collect(Collectors.toList()));
        return dishResponseDTO;
    }

    @Override
    public List<DishResponseDTO> getAllCalories(List<DishDTO> dishes) {
        List<DishResponseDTO> listDishes = new ArrayList<>();

        for(DishDTO dishDTO: dishes){
            listDishes.add(getCalories(dishDTO));
        }

        return listDishes.stream().sorted(Comparator.comparingInt(DishResponseDTO::getCalories).reversed()).collect(Collectors.toList());
    }

    @Override
    public IngredientDTO getIngredientsCalories() {
        return ingredientRepository.findMostCaloric();
    }
}
