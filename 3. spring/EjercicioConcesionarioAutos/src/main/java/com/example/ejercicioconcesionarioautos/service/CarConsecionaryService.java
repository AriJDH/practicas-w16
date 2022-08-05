package com.example.ejercicioconcesionarioautos.service;

import com.example.ejercicioconcesionarioautos.dto.CarDto;
import com.example.ejercicioconcesionarioautos.dto.CarDtoWoService;
import com.example.ejercicioconcesionarioautos.entiry.Car;
import com.example.ejercicioconcesionarioautos.repository.ICarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarConsecionaryService implements ICarRepositoryService {

    @Autowired
    ICarRepository carRepository;


    @Override
    public void insertCar(CarDto car) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        carRepository.insertCar(mapper.convertValue(car,Car.class));
    }

    @Override
    public List<CarDtoWoService> getCarList() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return carRepository.getCarList().stream().map(x->new CarDtoWoService(x.getId(),x.getBrand(),x.getBrand(),x.getManufacturingDate(),x.getNumberOfKilometers(),x.getDoors(),x.getPrice(),x.getCurrency(),x.getCountOfOwners())).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarListByDate(LocalDate sinceDate, LocalDate toDate) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return carRepository.getCarListByDate(sinceDate,toDate).stream().map(x->mapper.convertValue(x,CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarListByPrice(double priceStart, double priceEnd) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return carRepository.getCarListByPrice(priceStart,priceEnd).stream().map(x->mapper.convertValue(x,CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(int id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.convertValue(carRepository.getCarById(id),CarDto.class);
    }
}
