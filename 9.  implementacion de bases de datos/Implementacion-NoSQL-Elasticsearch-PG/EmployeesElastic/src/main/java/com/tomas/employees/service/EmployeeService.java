package com.tomas.employees.service;

import com.tomas.employees.dto.CreateDTO;
import com.tomas.employees.dto.EmployeeDTO;
import com.tomas.employees.dto.MessageDTO;
import com.tomas.employees.dto.UpdateEmployeeDTO;
import com.tomas.employees.mapper.Mapper;
import com.tomas.employees.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    Mapper mapper;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public CreateDTO saveEmployee(EmployeeDTO employeeDTO) {

        String id;
        id = employeeRepository.save(mapper.employeeDtoToEmployeeEntity(employeeDTO)).getId();

        CreateDTO createDto = new CreateDTO();
        if(id != null){
            createDto.setIdEmployee(id);
            createDto.setStatusCode(201);
            createDto.setMessage("Employee created successful");

        } else {

            createDto.setStatusCode(500);
            createDto.setMessage("Error, employee not created");

        }

        return createDto;
    }

    @Override
    public MessageDTO updateEmployee(UpdateEmployeeDTO employeeUpdate) {

        String id;
        id = employeeRepository.save(mapper.UpdateEmployeeDtoToEmployeeEntity(employeeUpdate)).getId();

        MessageDTO messageDTO = new MessageDTO();
        if(id != null){
            messageDTO.setStatusCode(200);
            messageDTO.setMessage("Employee updated successful");

        } else {

            messageDTO.setStatusCode(500);
            messageDTO.setMessage("Error, employee not update");

        }

        return messageDTO;
    }
}
