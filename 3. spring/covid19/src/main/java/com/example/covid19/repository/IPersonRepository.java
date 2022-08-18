package com.example.covid19.repository;

import com.example.covid19.entity.IPerson;
import com.example.covid19.entity.Person;

import java.util.List;

public interface IPersonRepository extends IRepository<IPerson> {
    List<IPerson> findPeopleOlderThan(Integer age);
}
