package com.tomas.calorias.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PlatoResponseDTO extends PlatoDTO {
    private Integer calories;


    public PlatoResponseDTO(PlatoDTO dish) {
        this.setIngredients(dish.getIngredients());
        this.setName(dish.getName());
    }
}
