package com.tomas.employees.service;

import com.tomas.employees.dto.CreateDTO;
import com.tomas.employees.dto.EmployeeDTO;
import com.tomas.employees.dto.MessageDTO;
import com.tomas.employees.dto.UpdateEmployeeDTO;

public interface IEmployeeService {

    CreateDTO saveEmployee(EmployeeDTO employeeDTO);
    MessageDTO updateEmployee(UpdateEmployeeDTO employeeUpdate);

}
