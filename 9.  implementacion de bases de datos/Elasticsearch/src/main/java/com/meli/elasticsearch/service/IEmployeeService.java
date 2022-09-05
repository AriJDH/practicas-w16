package com.meli.elasticsearch.service;

import com.meli.elasticsearch.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
    List<EmployeeDto> createEmployee(List<EmployeeDto> employeesDtos);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getEmployees();

    void deleteEmployees();
}
