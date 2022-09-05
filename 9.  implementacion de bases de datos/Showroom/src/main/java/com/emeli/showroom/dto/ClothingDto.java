package com.emeli.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothingDto {
    private String id;

    private String name;

    private String type;

    private String brand;

    private String color;

    private String size;

    private Integer amount;

    private Double price;
}
