package com.example.covid19.repository;

import java.util.List;

public interface IRepository<T> {
    public T findByName(String name);
    public List<T> findAll();
    public void add(T instance);
    public T findByPK(Integer id);
}
