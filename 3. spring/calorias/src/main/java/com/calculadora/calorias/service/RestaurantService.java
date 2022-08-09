package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.FoodMenuDTO;
import com.calculadora.calorias.entity.FoodMenu;
import com.calculadora.calorias.exception.NotFoundException;
import com.calculadora.calorias.mapper.FoodMenuMapper;
import com.calculadora.calorias.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService implements IRestaurantService {
    @Autowired
    private IRestaurantRepository restaurantRepository;

    public FoodMenuDTO findByName(String name, Double weight) {
        FoodMenu fm = restaurantRepository.findByName(name);
        if (fm != null) {
            FoodMenuMapper foodMenuMapper = new FoodMenuMapper();
            FoodMenuDTO foodMenuDTO = foodMenuMapper.ToDto(fm);
            foodMenuDTO.setCaloriesByWeight(fm.getTotalCaloriesByWeight(weight));
            return foodMenuDTO;
        } else {
            throw new NotFoundException("El plato " + name + " no existe");
        }
    }
}
