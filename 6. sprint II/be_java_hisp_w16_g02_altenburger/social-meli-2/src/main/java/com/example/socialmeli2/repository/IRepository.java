package com.example.socialmeli2.repository;

import java.util.List;

public interface IRepository<T> {
     T getById(Integer id);
     List<T> getAll();
     void update(T t);
     Integer add(T t);
     void dropAll();
}
