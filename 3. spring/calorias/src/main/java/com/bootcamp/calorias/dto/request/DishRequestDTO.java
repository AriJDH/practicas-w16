package com.bootcamp.calorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishRequestDTO {
    private String name;
    private Double weight;
}
