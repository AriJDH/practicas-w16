package com.meli.elasticsearch.controller;

import com.meli.elasticsearch.dto.EmployeeDto;
import com.meli.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody List<EmployeeDto> employeeDtos) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDtos), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteEmployees() {
        employeeService.deleteEmployees();
        return new ResponseEntity<>("Eliminados todos", HttpStatus.OK);
    }
}
