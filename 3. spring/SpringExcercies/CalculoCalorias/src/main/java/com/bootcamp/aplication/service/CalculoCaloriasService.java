package com.bootcamp.aplication.service;

import com.bootcamp.aplication.dto.OrderDTO;
import com.bootcamp.aplication.dto.ResponseDTO;
import com.bootcamp.aplication.entity.Dish;
import com.bootcamp.aplication.entity.Food;
import com.bootcamp.aplication.repository.CalculoCaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class CalculoCaloriasService implements ICalculoCaloriasService {

    @Autowired
    CalculoCaloriasRepository caloriasRepository;

    @Override
    public List<Food> findAllFood() {
        return caloriasRepository.getFoodList();
    }

    @Override
    public Food findFood(String s) {
        Food food = new Food();
        findAllFood().stream()
                .filter(v -> v.getName().equals(s))
                .forEach(data -> {
                    food.setName(data.getName());
                    food.setCalories(data.getCalories());
                });
        return food;
    }

    @Override
    public List<ResponseDTO> caloriesCalculate(List<OrderDTO> pedido) {
        List<ResponseDTO> responseList = new ArrayList<>();

        for (OrderDTO dto : pedido) {
            ResponseDTO responseDTO = new ResponseDTO();

            preloadIngredient().stream()
                    .filter(dataFilter -> dataFilter.getName().equals(dto.getName()))
                    .forEach(data -> {

                        List<Food> ingredientes = new ArrayList<>();
                        Arrays.stream(data.getIngredients())
                                .forEach(ingredient -> ingredientes.add(findFood(ingredient)));
                        responseDTO.setIngredientsList(ingredientes);

                        int totalCalories = ingredientes.stream().mapToInt(sumCalorias -> sumCalorias.getCalories()).sum();
                        responseDTO.setTotalCalories(totalCalories);

                        Food mostCalories = ingredientes.stream()
                                .sorted(Comparator.comparingInt(Food::getCalories).reversed())
                                .findFirst()
                                .get();

                        responseDTO.setMostCalorie(mostCalories);

                        responseList.add(responseDTO);
                    });
        }

        return responseList;
    }

    public List<Dish> preloadIngredient() {

        List<Dish> dishList = new ArrayList<>();

        String[] ingredientA = {"Pan de centeno", "Cebolla", "Tomates", "Ternera"};
        Dish hamburguesa = new Dish("Hamburguesa", ingredientA);
        dishList.add(hamburguesa);

        String[] ingredientB = {"Pan de centeno", "Cebolla", "Queso mozzarella"};
        Dish perro = new Dish("Perro", ingredientB);
        dishList.add(perro);

        String[] ingredient3 = {"Pan de centeno", "Cebolla", "Queso mozzarella"};
        Dish plato3 = new Dish("Plato3", ingredient3);
        dishList.add(plato3);

        return dishList;
    }
}
