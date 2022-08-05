package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarsRepository implements ICarsRepository<Car> {

    private HashMap<Integer, Car> cars;
    private int lastIndex;

    public CarsRepository(){
        this.cars = new HashMap<>();
    }

    public void add(Car car){
        car.setId(lastIndex);
        cars.put(lastIndex, car);
        lastIndex++;
    }

    public List<Car> getAll(){
        return this.cars.values().stream().collect(Collectors.toList());
    }

    @Override
    public Car get(int id) {
        return cars.get(id);
    }

}
