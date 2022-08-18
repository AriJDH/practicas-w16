package com.example.covid19.repository;

import com.example.covid19.entity.IPersonSympthomp;

import java.util.List;
import java.util.Map;

public interface IPersonSymthompRepository extends IRepository<IPersonSympthomp> {
    Map<Integer, IPersonSympthomp> findByListPersonIds(List<Integer> ids);
}
