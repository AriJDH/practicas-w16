package com.bootcamp.elspersonas.repository;

import com.bootcamp.elspersonas.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
}