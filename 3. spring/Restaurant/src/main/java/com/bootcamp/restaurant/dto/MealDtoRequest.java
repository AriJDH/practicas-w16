package com.bootcamp.restaurant.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDtoRequest {

    private String name;
    private Double weight;
}
