package com.bootcamp.blog.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository <T,U>{
    List<T> findAll();
    Optional<T> findById(U id);
    T save(T model);
}
