package com.example.sports.repository;

import com.example.sports.entity.IPerson;
import com.example.sports.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements IPersonRepository {
    private List<IPerson> people = new ArrayList<>();
    @Override
    public List<IPerson> findAll() {
        return this.people;
    }
    @Override
    public List<IPerson> findAllSportsman() {
        return this.people.stream().filter(iPerson -> iPerson.getSportId() != null).collect(Collectors.toList());
    }
}
