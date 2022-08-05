package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.response.DishDTO;
import com.bootcamp.calorias.entity.Dish;
import com.bootcamp.calorias.repository.DishRepository;
import com.bootcamp.calorias.utils.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService implements IService<DishDTO>{
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<DishDTO> getAll(){
        return dishRepository.getAll().stream()
                .map(Util::parseDishToDishDTO)
                .collect(Collectors.toList());
    }

    public DishDTO getByNameAndWeight(String name, Double weight){
        DishDTO dishDTO = dishRepository.getAll().stream()
                .filter(dish -> dish.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .map(dish -> Util.parseDishToDishWithWeightDTO(dish, weight))
                .get();
        return dishDTO;
    }
}
