package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDosRepository extends JpaRepository<Person, Long>{

    List<Person> findAllBySymptomIsNullAndAgeGreaterThan(Integer age);
}
