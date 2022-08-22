package com.example.socialmeli.repository;

import com.example.socialmeli.model.PostUS10;

import java.util.List;

public interface IRepository<T> {
     T getById(Integer id);
     List<T> getAll();
     void update(T t);
     Integer add(T t);
}
