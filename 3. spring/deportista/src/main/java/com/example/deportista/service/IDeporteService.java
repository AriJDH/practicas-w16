package com.example.deportista.service;

import java.util.List;

public interface IDeporteService <T>{
    List<T> getAll();
    T getByName(String name);
    List<T> getPersonas();
}
