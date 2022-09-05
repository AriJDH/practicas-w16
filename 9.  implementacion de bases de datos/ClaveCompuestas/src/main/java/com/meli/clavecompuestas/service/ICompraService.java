package com.meli.clavecompuestas.service;

import com.meli.clavecompuestas.dto.CompraDto;

import java.util.List;

public interface ICompraService {
    List<CompraDto> getCompras();
    CompraDto findCompra();
    CompraDto saveCompra();
    void deleteCompra();
}
