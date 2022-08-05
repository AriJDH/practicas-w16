package com.bootcamp.restaurant.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    private String name;
    private List<Ingredient> ingredients;
    private Double weight;
}
