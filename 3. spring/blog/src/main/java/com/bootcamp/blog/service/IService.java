package com.bootcamp.blog.service;

import java.util.List;

public interface IService<T,U> {
    List<T> findAll();
    T findById(U id);
}
