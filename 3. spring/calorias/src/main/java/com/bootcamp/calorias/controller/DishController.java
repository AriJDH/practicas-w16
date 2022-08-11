package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.response.DishDTO;
import com.bootcamp.calorias.dto.request.DishRequestDTO;

import com.bootcamp.calorias.service.DishService;
import com.bootcamp.calorias.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {
    private final IService<DishDTO> dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("dishes")
    public List<DishDTO> getAll(){
        return this.dishService.getAll();
    }

    @GetMapping("dish")
    public DishDTO getByNameAndWeight(@RequestBody DishRequestDTO dishDTO){
        return this.dishService.getByNameAndWeight(dishDTO.getName(), dishDTO.getWeight());
    }
}
