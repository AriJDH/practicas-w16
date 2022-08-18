package com.example.covid19.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    void add(T instance);
    T findByPK(Integer id);
}
