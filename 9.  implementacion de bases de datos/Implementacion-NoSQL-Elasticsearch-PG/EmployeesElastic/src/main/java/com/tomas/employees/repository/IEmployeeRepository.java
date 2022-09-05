package com.tomas.employees.repository;

import com.tomas.employees.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {


}
