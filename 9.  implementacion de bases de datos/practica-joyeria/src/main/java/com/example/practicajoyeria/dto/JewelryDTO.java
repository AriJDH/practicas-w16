package com.example.practicajoyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JewelryDTO {

    //todo: agregar validaciones
    private String name;
    private String material;
    private double weight;
    private boolean hasStone;
    private boolean sellable;
}
