package com.restaurante.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DishResponseDTO extends DishDTO{
    private Integer calories;


    public DishResponseDTO(DishDTO dish) {
        this.setIngredients(dish.getIngredients());
        this.setName(dish.getName());
    }
}
