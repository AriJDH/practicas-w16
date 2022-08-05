package com.bootcamp.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarService {
    private String date;
    private String kilometers;
    private String descriptions;
}
