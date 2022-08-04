package com.bootcamp.starwars.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    List<T> getByName(String name);
}
