package com.example.ejemplorelaciones.services;

import com.example.ejemplorelaciones.dto.CartDto;

public interface iCartService {
    CartDto save(CartDto cart);
    void delete(Long id);
}
