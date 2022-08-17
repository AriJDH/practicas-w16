package com.bootcamp.ejerciciospracticosp2vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    private String name;
    private List<Ingredient> ingredients;
    private Double weight;


}
