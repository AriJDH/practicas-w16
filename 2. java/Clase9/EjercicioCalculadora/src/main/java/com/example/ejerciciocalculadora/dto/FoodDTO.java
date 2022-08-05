package com.example.ejerciciocalculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private int calories;

    @Override
    public String toString() {
        return "FoodDTO{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}



