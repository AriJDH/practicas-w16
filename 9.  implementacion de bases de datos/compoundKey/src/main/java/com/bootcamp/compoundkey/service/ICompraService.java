package com.bootcamp.compoundkey.service;

import com.bootcamp.compoundkey.DTO.CompraDTO;

public interface ICompraService {
  CompraDTO crearCompra(CompraDTO compra);
  CompraDTO getById(Integer id, String fecha);
}
