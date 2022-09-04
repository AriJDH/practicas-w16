package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    Employee findByNombre(String nombre);
}
