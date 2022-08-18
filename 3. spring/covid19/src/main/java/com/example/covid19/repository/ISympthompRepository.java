package com.example.covid19.repository;

import com.example.covid19.entity.IPersonSympthomp;
import com.example.covid19.entity.ISympthomp;

import java.util.List;
import java.util.Map;

public interface ISympthompRepository extends IRepository<ISympthomp> {
    ISympthomp findByName(String name);
}
