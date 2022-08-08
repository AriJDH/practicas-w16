package com.bootcamp.calorias.repository;

import java.util.List;

public interface IRepository<T>{
    List<T> getAll();
}
