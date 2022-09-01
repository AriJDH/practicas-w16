package com.example.ejemplorelaciones.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartDto {

    private Long id;
    private Set<ItemDto> items;

}
