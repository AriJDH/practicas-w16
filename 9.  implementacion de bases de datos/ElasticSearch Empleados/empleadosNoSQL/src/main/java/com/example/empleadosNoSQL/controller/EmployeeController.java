package com.example.empleadosNoSQL.controller;

import com.example.empleadosNoSQL.dto.EmployeeDto;
import com.example.empleadosNoSQL.dto.StatusDto;
import com.example.empleadosNoSQL.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/created")
    public ResponseEntity<StatusDto> createEmployee(@RequestBody List<EmployeeDto> employees){
        return new ResponseEntity<>(employeeService.createEmployees(employees),HttpStatus.CREATED);
    }

    @PutMapping("/updated")
    public ResponseEntity<EmployeeDto> updatedEmployee(@RequestBody EmployeeDto employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<Iterable<EmployeeDto>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.FOUND);
    }

}
