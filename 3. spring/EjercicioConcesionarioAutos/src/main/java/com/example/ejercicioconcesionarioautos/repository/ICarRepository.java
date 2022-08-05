package com.example.ejercicioconcesionarioautos.repository;

import com.example.ejercicioconcesionarioautos.entiry.Car;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface ICarRepository {

    void insertCar(Car car);

    List<Car> getCarList();

    List<Car> getCarListByDate(LocalDate sinceDate, LocalDate toDate);

    List<Car> getCarListByPrice(double priceStart,double priceEnd);
    Car getCarById(int id);


}
