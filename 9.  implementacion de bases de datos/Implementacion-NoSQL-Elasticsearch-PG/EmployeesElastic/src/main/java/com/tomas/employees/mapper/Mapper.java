package com.tomas.employees.mapper;

import com.tomas.employees.dto.EmployeeDTO;
import com.tomas.employees.dto.UpdateEmployeeDTO;
import com.tomas.employees.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Employee employeeDtoToEmployeeEntity(EmployeeDTO employeeDto){

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setCity(employeeDto.getCity());
        employee.setState(employeeDto.getState());

        return employee;

    }

    public Employee UpdateEmployeeDtoToEmployeeEntity(UpdateEmployeeDTO employeeDto){

        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setCity(employeeDto.getCity());
        employee.setState(employeeDto.getState());

        return employee;

    }

}
