package com.ndemaio.ejerciciocalculadoradecalorias.service;

import com.ndemaio.ejerciciocalculadoradecalorias.entity.Food;
import com.ndemaio.ejerciciocalculadoradecalorias.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void addFoodList(List<Food> foods) {
        foodRepository.save(foods);
    }
}
