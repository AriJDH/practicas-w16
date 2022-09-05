package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.SaleDto;
import com.bootcamp.showroom.dto.SaleFilterDto;

import java.util.List;

public interface ISaleService {
    List<SaleDto> findAll(SaleFilterDto saleDto);

    SaleDto findByNumber(Long number);

    SaleDto findAllClothesBySaleNumber(Long number);

    SaleDto save(SaleDto saleDto);

    SaleDto updateByNumber(Long number, SaleDto saleDto);

    void deleteByNumber(Long number);
}
