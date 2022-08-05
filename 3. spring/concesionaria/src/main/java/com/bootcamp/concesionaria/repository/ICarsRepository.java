package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.model.Car;

import java.util.List;

public interface ICarsRepository<T> {

    public void add(T t);
    public List<T> getAll();
    public T get(int id);
}
