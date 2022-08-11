package com.bootcamp.dealership.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IService <T, U> {
    List<T> findAll(Map<String,String> filter);
    List<T> findByPrices(Map<String,String> filter);
    List<T> findByDates(Map<String, String> filter);
    T findById(Long id);
    T save(U model);
}
