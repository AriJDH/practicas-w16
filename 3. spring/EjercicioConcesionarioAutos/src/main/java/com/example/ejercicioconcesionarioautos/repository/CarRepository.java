package com.example.ejercicioconcesionarioautos.repository;

import com.example.ejercicioconcesionarioautos.entiry.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository implements ICarRepository{
    List<Car> carList = new ArrayList<>();

    @Override
    public void insertCar(Car car) {
        carList.add(car);
    }

    @Override
    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public List<Car> getCarListByDate(LocalDate sinceDate, LocalDate toDate) {
        return carList.stream().filter(x->!(x.getManufacturingDate().isBefore(sinceDate) || x.getManufacturingDate().isAfter((toDate)))).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarListByPrice(double priceStart,double priceEnd) {
        return carList.stream().filter(x->x.getPrice() >=priceStart && x.getPrice()<= priceEnd).collect(Collectors.toList());
    }

    @Override
    public Car getCarById(int id) {
        return carList.stream().filter(x->x.getId() == id).findFirst().get();
    }

}
