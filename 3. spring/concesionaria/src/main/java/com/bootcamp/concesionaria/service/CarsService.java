package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.CarDto;
import com.bootcamp.concesionaria.dto.CarRequestDto;
import com.bootcamp.concesionaria.model.Car;
import com.bootcamp.concesionaria.model.CarService;
import com.bootcamp.concesionaria.repository.ICarsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarsService {

    ICarsRepository carsRepository;

    public CarsService(ICarsRepository carsRepository){
        this.carsRepository = carsRepository;
    }


    public void addCar(CarRequestDto car){
        List<CarService> services = new ArrayList<>();
        car.getServices().forEach(x -> services.add(new CarService(x.getDate(), x.getKilometers(), x.getDescriptions())));

        carsRepository.add(new Car(car.getBrand(), car.getModel(), car.getManufacturingDate(), car.getNumberOfKilometers(),
                car.getDoors(), car.getPrice(), car.getCurrency(), car.getCountOfOwners(), services));
    }

    public List<CarDto> getAllCars(){
        List<CarDto> cars = new ArrayList<>();

        List<Car> allCars =  carsRepository.getAll();
        System.out.println(allCars);
        allCars.forEach(car -> cars.add(new CarDto(car.getBrand(), car.getModel(), car.getManufacturingDate(), car.getNumberOfKilometers(),
                car.getDoors(), car.getPrice(), car.getCurrency(), car.getCountOfOwners(), car.getId())));

        return cars;
    }


    public List<CarDto> getCars(String fromStr, String toStr){
        List<CarDto> cars = new ArrayList<>();
        List<Car> allCars =  carsRepository.getAll();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromDate = LocalDate.parse(fromStr, dtf);
        LocalDate toDate = LocalDate.parse(toStr, dtf);

        allCars.stream().filter(c -> LocalDate.parse(c.getManufacturingDate(), dtf).isAfter(fromDate)
                        && LocalDate.parse(c.getManufacturingDate(), dtf).isBefore(toDate))
                .forEach(car -> cars.add(new CarDto(car.getBrand(), car.getModel(), car.getManufacturingDate(),
                        car.getNumberOfKilometers(), car.getDoors(), car.getPrice(), car.getCurrency(),
                        car.getCountOfOwners(), car.getId())));

        return cars;
    }

    public List<CarDto> getCarsPrice(String fromPrice, String toPrice){
        List<CarDto> cars = new ArrayList<>();
        List<Car> allCars =  carsRepository.getAll();

        int from = Integer.valueOf(fromPrice);
        int to = Integer.valueOf(toPrice);

        allCars.stream().filter(c -> Integer.valueOf(c.getPrice()) >= from && Integer.valueOf(c.getPrice()) <= to)
                .forEach(car -> cars.add(new CarDto(car.getBrand(), car.getModel(), car.getManufacturingDate(),
                        car.getNumberOfKilometers(), car.getDoors(), car.getPrice(), car.getCurrency(),
                        car.getCountOfOwners(), car.getId())));

        return cars;
    }


    public CarDto getCar(int id){
        Car car = (Car) carsRepository.get(id);
        return new CarDto(car.getBrand(), car.getModel(), car.getManufacturingDate(), car.getNumberOfKilometers(),
                car.getDoors(), car.getPrice(), car.getCurrency(), car.getCountOfOwners(), car.getId());
    }
}
