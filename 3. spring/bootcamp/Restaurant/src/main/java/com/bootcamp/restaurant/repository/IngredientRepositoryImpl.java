package com.bootcamp.restaurant.repository;

import com.bootcamp.restaurant.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository{


    @Override
    public List<Ingredient> getAll() {
        return loadIngredients();
    }



    private List<Ingredient> loadIngredients() {

        try (
                Reader reader = new FileReader("/Users/marmejia/Documents/bootcamp/practicas-w16/3. spring/bootcamp/Restaurant/src/main/resources/3. food.json")) {
            ObjectMapper mapper = new ObjectMapper();
            List<Ingredient> ingredients = mapper.readValue(reader, new TypeReference<List<Ingredient>>(){});
            return ingredients;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

}
