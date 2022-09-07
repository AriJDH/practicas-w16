package com.bootcamp.aplication.dto;

import com.bootcamp.aplication.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private int totalCalories;
    private List<Food> ingredientsList;
    private Food mostCalorie;
}
