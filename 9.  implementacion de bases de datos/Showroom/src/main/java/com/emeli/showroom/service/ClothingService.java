package com.emeli.showroom.service;

import com.emeli.showroom.dto.ClothingDto;
import com.emeli.showroom.entity.Clothing;
import com.emeli.showroom.repository.IClothingRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClothingService implements ICLothingService{

    private IClothingRepository clothingRepository;

    private ModelMapper modelMapper;

    public ClothingService(IClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
        modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothingDto> getClothing() {
        List<Clothing> clothing = clothingRepository.findAll();
        List<ClothingDto> clothingDtos = clothing.stream().map(x -> modelMapper.map(x, ClothingDto.class)).collect(Collectors.toList());

        return clothingDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public ClothingDto findClothing(String id) {
        Clothing clothing = clothingRepository.findById(id).orElse(null);
        ClothingDto clothingDto = modelMapper.map(clothing, ClothingDto.class);

        return clothingDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothingDto> findClothingBySize(String size) {
        List<Clothing> clothing = clothingRepository.findBySize(size);

        List<ClothingDto> clothingDtos = clothing.stream().map(x -> modelMapper.map(x, ClothingDto.class)).collect(Collectors.toList());;

        return clothingDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothingDto> findClothingByName(String name) {
        List<Clothing> clothing = clothingRepository.findByName(name);
        List<ClothingDto> clothingDtos = clothing.stream().map(x -> modelMapper.map(x, ClothingDto.class)).collect(Collectors.toList());

        return clothingDtos;
    }

    @Override
    @Transactional
    public ClothingDto saveClothing(ClothingDto clothingDto) {
        return null;
    }

    @Override
    @Transactional
    public ClothingDto updateClothing(ClothingDto clothingDto) {
        return null;
    }

    @Override
    @Transactional
    public void deleteClothingById(String id) {

    }
}
