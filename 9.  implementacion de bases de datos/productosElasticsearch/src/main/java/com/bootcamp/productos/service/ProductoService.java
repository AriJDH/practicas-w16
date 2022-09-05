package com.bootcamp.productos.service;

import com.bootcamp.productos.dto.ProductoDto;
import com.bootcamp.productos.entity.Producto;
import com.bootcamp.productos.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public ProductoDto create(ProductoDto productoDto) {
        Producto producto = new Producto(productoDto.getNombre(), productoDto.getTipo(), productoDto.getPrecio(),productoDto.getPrecioProduccion(), productoDto.getCantidadDisponible());
        Producto result = productoRepository.save(producto);

        return new ProductoDto(result.getId(), result.getNombre(), result.getTipo(), result.getPrecio(), result.getPrecioProduccion(), result.getCantidadDisponible());
    }

    @Override
    public List<ProductoDto> getProducts() {
        List<ProductoDto> productoList = new ArrayList<>();
        productoRepository.findAll().forEach(p -> productoList.add(new ProductoDto(p.getId(), p.getNombre(), p.getTipo(), p.getPrecio(), p.getPrecioProduccion(), p.getCantidadDisponible())));

        return productoList;
    }

    @Override
    public String delete(String id) {

        productoRepository.deleteById(id);

        return "Producto eliminado: " + id;
    }
}
