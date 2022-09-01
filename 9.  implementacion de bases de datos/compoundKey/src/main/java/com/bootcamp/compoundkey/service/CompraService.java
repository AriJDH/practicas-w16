package com.bootcamp.compoundkey.service;

import com.bootcamp.compoundkey.DTO.CompraDTO;
import com.bootcamp.compoundkey.model.Compra;
import com.bootcamp.compoundkey.model.CompraId;
import com.bootcamp.compoundkey.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CompraService implements ICompraService {

  @Autowired
  ICompraRepository compraRepository;
  private final ModelMapper mapper;

  public CompraService() {
    this.mapper = new ModelMapper();
  }

  @Override
  public CompraDTO crearCompra(CompraDTO compraDTO) {
    Compra compra = compraRepository.save(mapper.map(compraDTO, Compra.class));

    return mapper.map(compra, CompraDTO.class);

  }

  @Override
  public CompraDTO getById(Integer id, String fecha) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date = LocalDate.parse(fecha, dtf);
    Compra compra = compraRepository.getReferenceById(new CompraId(id, date));
    return mapper.map(compra, CompraDTO.class);
  }
}
