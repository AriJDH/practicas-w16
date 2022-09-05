package com.meli.elasticsearch.service;

import com.meli.elasticsearch.dto.EmployeeDto;
import com.meli.elasticsearch.entity.Employee;
import com.meli.elasticsearch.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public List<EmployeeDto> createEmployee(List<EmployeeDto> employeesDtos) {
        List<Employee> employees = employeesDtos.stream().map(employee -> modelMapper.map(employee, Employee.class)).collect(Collectors.toList());

        employeeRepository.saveAll(employees);

        return employeesDtos;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee = employeeRepository.save(employee);

        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();

        List<Employee> employeeList = StreamSupport.stream(employees.spliterator(), false).collect(Collectors.toList());

        List<EmployeeDto> employeesDtos = employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

        return employeesDtos;
    }

    @Override
    public void deleteEmployees() {
        employeeRepository.deleteAll();
    }
}
