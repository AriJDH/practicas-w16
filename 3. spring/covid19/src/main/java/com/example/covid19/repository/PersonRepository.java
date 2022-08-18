package com.example.covid19.repository;

import com.example.covid19.entity.IPerson;
import com.example.covid19.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements IPersonRepository {
    private  List<IPerson> people= new ArrayList<>();

    @Override
    public List<IPerson> findPeopleOlderThan(Integer age) {
        return this.people.stream().filter(iPerson -> iPerson.getAge() <= age).collect(Collectors.toList());
    };

    @Override
    public List<IPerson> findAll() {
        return this.people;
    }

    @Override
    public void add(IPerson instance) {
        this.people.add(instance);
    }

    @Override
    public IPerson findByPK(Integer id) {
        return this.people.stream().filter(iPerson -> iPerson.getId().equals(id)).findFirst().orElse(null);
    }
}
