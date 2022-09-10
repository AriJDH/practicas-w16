package com.bootcamp.restaurant.entity;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    private String name;
    private Integer calories;
}
