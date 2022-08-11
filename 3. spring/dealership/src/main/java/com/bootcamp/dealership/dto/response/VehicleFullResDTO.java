package com.bootcamp.dealership.dto.response;

import com.bootcamp.dealership.entity.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleFullResDTO {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Long price;
    private String currency;
    private Integer countOfOwners;
    private List<ServiceDTO> services;
}
