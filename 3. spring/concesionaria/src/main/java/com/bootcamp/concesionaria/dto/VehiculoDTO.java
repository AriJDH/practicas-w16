package com.bootcamp.concesionaria.dto;

import com.bootcamp.concesionaria.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
  private String brand;
  private String model;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date manufacturingDate;
  private long numberOfKilometers;
  private int doors;
  private double price;
  private String currency;
  private List<Service> services;
  private int countOfOwners;
}