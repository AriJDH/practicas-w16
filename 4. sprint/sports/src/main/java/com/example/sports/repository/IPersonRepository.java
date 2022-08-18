package com.example.sports.repository;

import com.example.sports.entity.IPerson;
import com.example.sports.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<IPerson> findAll();
    List<IPerson> findAllSportsman();
}
