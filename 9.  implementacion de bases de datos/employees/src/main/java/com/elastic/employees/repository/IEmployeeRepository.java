package com.elastic.employees.repository;

import com.elastic.employees.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findAll();
}
