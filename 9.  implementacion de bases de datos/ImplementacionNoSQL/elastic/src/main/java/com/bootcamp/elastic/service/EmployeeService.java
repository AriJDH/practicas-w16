package com.bootcamp.elastic.service;

import com.bootcamp.elastic.entity.Employee;
import com.bootcamp.elastic.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employee1 = employeeRepository.findByNombre(employee.getNombre());
        if(employee.getApellido()!=null){
            employee1.setApellido(employee.getApellido());
        }
        return employee1;
    }
}
