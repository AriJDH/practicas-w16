package com.example.ejconcesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private Date manuFacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
    private List<Service> services;
}
