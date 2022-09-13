package com.example.empleadosNoSQL.service;

import com.example.empleadosNoSQL.dto.EmployeeDto;
import com.example.empleadosNoSQL.dto.StatusDto;
import com.example.empleadosNoSQL.entity.Employee;
import com.example.empleadosNoSQL.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    ModelMapper modelMapper;

    public EmployeeServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public StatusDto createEmployees(List<EmployeeDto> employeesDto) {
        List<Employee> employees = employeesDto.stream()
                .map(employeeDto -> new Employee(employeeDto.getId(),employeeDto.getName(),employeeDto.getLast_name(),
                        employeeDto.getAge(),employeeDto.getCity(),employeeDto.getProvince(),
                        employeeDto.getState(),employeeDto.getDepartment(),employeeDto.getFechaNacimiento()))
                .collect(Collectors.toList());
        employeeRepository.saveAll(employees);
        return new StatusDto("Employees created");
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(modelMapper.map(employeeDto,Employee.class));
        EmployeeDto employeeDtoUpdated = modelMapper.map(employee,EmployeeDto.class);
        return employeeDtoUpdated;
    }

    @Override
    public Iterable<EmployeeDto> getEmployees() {

        Iterable<Employee> employees = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employees.forEach(employeeList::add);
        List<EmployeeDto> employeeDtoList = employeeList.stream()
                .map(employee -> modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
        return employeeDtoList;
    }
}
