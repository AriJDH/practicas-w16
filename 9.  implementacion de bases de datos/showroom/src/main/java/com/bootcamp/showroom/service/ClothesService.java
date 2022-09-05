package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.ClothesDto;
import com.bootcamp.showroom.entity.Clothes;
import com.bootcamp.showroom.exception.NotFoundException;
import com.bootcamp.showroom.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClothesService implements IClothesService {
    @Autowired
    private IClothesRepository clothesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClothesDto> findAll(ClothesDto filters) {
        Stream<ClothesDto> filtered = clothesRepository.findAll().stream()
                .map(this::mapToClothesDto);

        if (filters.getName() != null)
            filtered = filtered.filter(c -> c.getName().compareToIgnoreCase(filters.getName()) > -1);

        if (filters.getSize() != null)
            filtered = filtered.filter(c -> c.getSize().equals(filters.getSize()));

        return filtered.collect(Collectors.toList());
    }

    @Override
    public ClothesDto save(ClothesDto clothesDto) {
        return mapToClothesDto(clothesRepository.save(mapToClothes(clothesDto)));
    }

    @Override
    public ClothesDto findByCode(String code) {
        return mapToClothesDto(clothesRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException(String.format("The clothe with the code %s don't exists.", code))));
    }

    @Override
    public List<ClothesDto> findBySize(String size) {
        return clothesRepository.findBySize(size).stream()
                .map(this::mapToClothesDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClothesDto updateByCode(String code, ClothesDto clothesDto) {
        Clothes clothes = clothesRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException(String.format("The clothe with the code %s don't exists.", code)));
        modelMapper.map(clothesDto, clothes);
        return mapToClothesDto(clothesRepository.save(clothes));
    }

    @Override
    public void deleteByCode(String code) {
        Clothes clothes = clothesRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException(String.format("The clothe with the code %s don't exists.", code)));
        clothesRepository.delete(clothes);
    }

    private Clothes mapToClothes(ClothesDto clothesDto) {
        return modelMapper.map(clothesDto, Clothes.class);
    }

    private ClothesDto mapToClothesDto(Clothes clothes) {
        return modelMapper.map(clothes, ClothesDto.class);
    }
}
