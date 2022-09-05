package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.ClothesDto;
import com.bootcamp.showroom.dto.SaleDto;
import com.bootcamp.showroom.dto.SaleFilterDto;
import com.bootcamp.showroom.entity.Clothes;
import com.bootcamp.showroom.entity.Sale;
import com.bootcamp.showroom.exception.NotFoundException;
import com.bootcamp.showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SaleDto> findAll(SaleFilterDto saleDto) {
        Stream<SaleDto> filtered = saleRepository.findAll().stream()
                .map(this::mapToSaleDto);

        if (saleDto.getDate() != null) {
            filtered = filtered.filter(s -> s.getDate().compareTo(saleDto.getDate()) == 0);
        }

        return filtered.collect(Collectors.toList());
    }

    @Override
    public SaleDto findByNumber(Long number) {
        Sale sale = saleRepository.findByNumber(number)
                .orElseThrow(() -> new NotFoundException(String.format("The sale with the number %s don't exists.", number)));
        sale.setClothes(null);
        return mapToSaleDto(sale);
    }

    @Override
    public SaleDto findAllClothesBySaleNumber(Long number) {
        Sale sale = saleRepository.findByNumber(number)
                .orElseThrow(() -> new NotFoundException(String.format("The sale with the number %s don't exists.", number)));
        return mapToSaleDto(sale);
    }

    @Override
    public SaleDto save(SaleDto saleDto) {
        try {
            Sale sale = mapToSale(saleDto);
            if (sale.getClothes() != null)
                sale.getClothes().forEach(c -> c.setSale(sale));
            return mapToSaleDto(saleRepository.save(sale));
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public SaleDto updateByNumber(Long number, SaleDto saleDto) {
        try {
            Sale sale = saleRepository.findByNumber(number)
                    .orElseThrow(() -> new NotFoundException(String.format("The sale with the number %s don't exists.", number)));
            modelMapper.map(mapToSale(saleDto), sale);
            if (sale.getClothes() != null)
                sale.getClothes().forEach(c -> c.setSale(sale));
            return mapToSaleDto(saleRepository.save(sale));
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteByNumber(Long number) {
        Sale sale = saleRepository.findByNumber(number)
                .orElseThrow(() -> new NotFoundException(String.format("The sale with the number %s don't exists.", number)));
        saleRepository.delete(sale);
    }

    private Sale mapToSale(SaleDto saleDto) {
        Sale sale = modelMapper.map(saleDto, Sale.class);
        if (saleDto.getClothes() != null) {
            sale.setClothes(saleDto.getClothes().stream()
                    .map(this::mapToClothes)
                    .collect(Collectors.toList()));
        }
        return sale;
    }

    private SaleDto mapToSaleDto(Sale sale) {
        SaleDto saleDto = modelMapper.map(sale, SaleDto.class);
        if (sale.getClothes() != null) {
            saleDto.setClothes(sale.getClothes().stream()
                    .map(this::mapToClothesDto)
                    .collect(Collectors.toList()));
        }
        return saleDto;
    }

    private Clothes mapToClothes(ClothesDto clothesDto) {
        return modelMapper.map(clothesDto, Clothes.class);
    }

    private ClothesDto mapToClothesDto(Clothes clothes) {
        return modelMapper.map(clothes, ClothesDto.class);
    }


}
