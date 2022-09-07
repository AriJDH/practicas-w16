package com.bootcamp.aplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private String brand;
    private String model;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate manufacturingDate;

    private String nomberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<CarServiceDTO> services;
    private String countOfOwners;
}
