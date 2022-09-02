package com.example.practicajoyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JewelryResponseDTO {
    private long id;
    private String name;
    private String material;
    private double weight;
    private boolean hasStone;
    private boolean sellable;
}
