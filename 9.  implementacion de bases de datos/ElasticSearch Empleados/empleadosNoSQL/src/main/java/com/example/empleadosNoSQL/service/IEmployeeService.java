package com.example.empleadosNoSQL.service;

import com.example.empleadosNoSQL.dto.EmployeeDto;
import com.example.empleadosNoSQL.dto.StatusDto;
import com.example.empleadosNoSQL.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    StatusDto createEmployees(List<EmployeeDto> employeesDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    Iterable<EmployeeDto> getEmployees();

}
