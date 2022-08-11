package com.bootcamp.calorias.service;

import java.util.List;

public interface IService<T>{
    List<T> getAll();
    T getByNameAndWeight(String name, Double weight);
}
