package com.example.covid19.repository;

import com.example.covid19.entity.Person;

import java.util.List;

public interface IPersonRepository <T> extends IRepository<T> {
    public List<T> findRiskPerson();
}
