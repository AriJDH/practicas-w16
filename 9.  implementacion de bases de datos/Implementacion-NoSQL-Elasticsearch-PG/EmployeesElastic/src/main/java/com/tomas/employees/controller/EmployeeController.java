package com.tomas.employees.controller;

import com.tomas.employees.dto.CreateDTO;
import com.tomas.employees.dto.EmployeeDTO;
import com.tomas.employees.dto.MessageDTO;
import com.tomas.employees.dto.UpdateEmployeeDTO;
import com.tomas.employees.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("save")
    public ResponseEntity<CreateDTO> saveEmployee(@RequestBody EmployeeDTO employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<MessageDTO> updateEmployee(@RequestBody UpdateEmployeeDTO updateEmployee){
        return new ResponseEntity<>(employeeService.updateEmployee(updateEmployee), HttpStatus.OK);
    }

}
