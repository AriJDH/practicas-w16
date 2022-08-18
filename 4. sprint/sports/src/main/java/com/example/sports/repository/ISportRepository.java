package com.example.sports.repository;

import com.example.sports.entity.ISport;

import java.util.List;
import java.util.Map;

public interface ISportRepository {
    List<ISport> findAll();
    ISport findByName(String name);
    Map<Integer, ISport> findByIds(List<Integer> ids);
}
