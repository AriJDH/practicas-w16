package com.bootcamp.concecionariaautos.service;

import com.bootcamp.concecionariaautos.dto.CarDTO;
import com.bootcamp.concecionariaautos.models.Car;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private Map<Long,Car> cars = new HashMap<>();
    private Long id;

    public CarServiceImpl() {
        this.id = 1L;
    }



    @Override
    public void addCar(Car car) {
        this.cars.put(id,car);
        this.id++;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return cars.entrySet().stream().map(car -> getCarDto(car.getValue())).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByDate(Date since, Date to) {
        return cars.entrySet().stream().map(x -> {
            Car car = x.getValue();
            if(car.getManufacturingDate().after(since) && car.getManufacturingDate().before(to)){
                return car;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByPrice(Double since, Double to) {
        return cars.entrySet().stream().map(x -> {
            Car car = x.getValue();
            if(car.getPrice()>=since && car.getPrice()<=to ){
                return car;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public Car getCarById(Long id) {
        return cars.get(id);
    }


    private CarDTO getCarDto(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setManufacturingDate(car.getManufacturingDate());
        carDTO.setNumberOfKilometers(car.getNumberOfKilometers());
        carDTO.setDoors(car.getDoors());
        carDTO.setPrice(car.getPrice());
        carDTO.setCurrency(car.getCurrency());
        carDTO.setCountOfOwners(car.getCountOfOwners());

        return carDTO;
    }
}
