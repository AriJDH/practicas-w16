package com.meli.seguroshql.dto;

import com.meli.seguroshql.model.Sinister;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private Integer yearProduction;
    private Integer numberWheels;
    private List<Sinister> sinisters;
}
