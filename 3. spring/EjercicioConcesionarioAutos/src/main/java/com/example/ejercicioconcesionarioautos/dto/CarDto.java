package com.example.ejercicioconcesionarioautos.dto;

import com.example.ejercicioconcesionarioautos.entiry.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private int id;
    private String brand;
    private String model;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    List<Service> services;
    private int countOfOwners;
}
