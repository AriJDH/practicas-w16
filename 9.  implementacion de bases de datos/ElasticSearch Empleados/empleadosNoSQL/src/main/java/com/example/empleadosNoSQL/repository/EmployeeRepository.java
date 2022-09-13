package com.example.empleadosNoSQL.repository;

import com.example.empleadosNoSQL.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {


}
