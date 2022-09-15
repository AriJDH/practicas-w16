package com.elastic.employees.controller;

import com.elastic.employees.dto.ReqEmployeeDTO;
import com.elastic.employees.entity.Employee;
import com.elastic.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class employeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(this.employeeService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity addOne(@RequestBody ReqEmployeeDTO reqEmployeeDTO) {
        this.employeeService.addOne(reqEmployeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
