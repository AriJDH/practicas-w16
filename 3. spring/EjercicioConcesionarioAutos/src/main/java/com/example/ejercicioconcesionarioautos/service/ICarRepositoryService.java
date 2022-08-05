package com.example.ejercicioconcesionarioautos.service;

import com.example.ejercicioconcesionarioautos.dto.CarDto;
import com.example.ejercicioconcesionarioautos.dto.CarDtoWoService;


import java.time.LocalDate;
import java.util.List;

public interface ICarRepositoryService {

    void insertCar(CarDto car);

    List<CarDtoWoService> getCarList();

    List<CarDto> getCarListByDate(LocalDate sinceDate, LocalDate toDate);

    List<CarDto> getCarListByPrice(double priceStart,double priceEnd);

    CarDto getCarById(int id);
}
