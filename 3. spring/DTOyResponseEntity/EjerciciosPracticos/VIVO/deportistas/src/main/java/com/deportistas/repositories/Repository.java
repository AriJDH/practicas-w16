package com.deportistas.repositories;

import java.util.List;

public interface Repository<T> {
    public List<T> findAll();
    public void save(T entity);
    public void delete(T entity);
}
