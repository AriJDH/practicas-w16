package com.calculadora.calorias.repository;

import com.calculadora.calorias.entity.FoodMenu;
import com.calculadora.calorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RestaurantRepositoryImpl implements IRestaurantRepository {
    private final List<Ingredient> dataBase;
    private final List<FoodMenu> foodMenuList;

    public RestaurantRepositoryImpl() {
        this.dataBase = loadDataBase();
        this.foodMenuList = loadFoodMenu();
    }
    @Override
    public FoodMenu findByName(String name) {
        return foodMenuList.stream().filter(elem -> elem.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredientList = null;
        try {
            ingredientList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }

    private List<FoodMenu> loadFoodMenu() {

        List<Ingredient> ingredients = this.dataBase.stream()
                .filter(elem -> elem.getName().equalsIgnoreCase("Hamburguesa") ||
                        elem.getName().equalsIgnoreCase("Papas fritas"))
                .collect(Collectors.toList());

        FoodMenu hamburguesaConPapasFritas = new FoodMenu("Hamburguesa con papas fritas", ingredients);

        ingredients = this.dataBase.stream()
                .filter(elem -> elem.getName().equalsIgnoreCase("Pollo") ||
                        elem.getName().equalsIgnoreCase("Lechuga") ||
                        elem.getName().equalsIgnoreCase("Tomates"))
                .collect(Collectors.toList());

        FoodMenu polloConEnsalada = new FoodMenu("Pollo con ensalada", ingredients);

        return List.of(hamburguesaConPapasFritas, polloConEnsalada);
    }
}
