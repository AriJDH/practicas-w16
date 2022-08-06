package com.bootcamp.concecionariaautos.service;

import com.bootcamp.concecionariaautos.dto.CarDTO;
import com.bootcamp.concecionariaautos.models.Car;

import java.util.Date;
import java.util.List;

public interface CarService {

    public void addCar(Car car);

    public List<CarDTO> getAllCars();

    public List<Car> getCarsByDate(Date since, Date to);

    public List<Car> getCarsByPrice(Double since, Double to);

    public Car getCarById(Long id);
}
