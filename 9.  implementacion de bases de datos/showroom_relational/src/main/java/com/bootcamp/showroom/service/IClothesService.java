package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.ClothesDto;

import java.util.List;

public interface IClothesService {
    List<ClothesDto> findAll(ClothesDto filters);
    ClothesDto save(ClothesDto clothesDto);
    ClothesDto findByCode(String code);

    List<ClothesDto> findBySize(String size);

    ClothesDto updateByCode(String code, ClothesDto clothesDto);
    void deleteByCode(String code);
}
