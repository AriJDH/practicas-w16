package com.elastic.employees.service;

import com.elastic.employees.dto.ReqEmployeeDTO;
import com.elastic.employees.entity.Employee;
import com.elastic.employees.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
    public void addOne(ReqEmployeeDTO reqEmployeeDTO) {
        Employee employee = new Employee();
        employee.setName(reqEmployeeDTO.getName());
        employee.setLastname(reqEmployeeDTO.getLastname());
        employee.setAge(reqEmployeeDTO.getAge());
        employee.setCity(reqEmployeeDTO.getCity());
        employee.setDepartment(reqEmployeeDTO.getDepartment());
        this.employeeRepository.save(employee);
    }
}
