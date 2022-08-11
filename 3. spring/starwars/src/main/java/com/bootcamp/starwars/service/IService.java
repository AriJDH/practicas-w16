package com.bootcamp.starwars.service;

import java.util.List;
import java.util.Map;

public interface IService<T>{
    List<T> getAll();
    List<T> getByName(String name);
}
