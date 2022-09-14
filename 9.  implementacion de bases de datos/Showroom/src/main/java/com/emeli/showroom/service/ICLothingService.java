package com.emeli.showroom.service;

import com.emeli.showroom.dto.ClothingDto;

import java.util.List;

public interface ICLothingService {
    List<ClothingDto> getClothing();
    ClothingDto findClothing(Long id);
    List<ClothingDto> findClothingBySize(String size);
    List<ClothingDto> findClothingByName(String name);
    ClothingDto saveClothing(ClothingDto clothingDto);
    ClothingDto updateClothing(ClothingDto clothingDto);
    void deleteClothingById(Long id);
}
