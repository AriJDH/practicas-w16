package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Employee;
import com.bootcamp.elastic.repository.EmployeeRepository;
import com.bootcamp.elastic.service.EmployeeService;
import com.bootcamp.elastic.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    IEmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService){
        this.employeeRepository= employeeRepository;
        this.employeeService=employeeService;
    }
    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody List<Employee> employees){
        return new ResponseEntity<>(employeeRepository.saveAll(employees), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllEmployees(){
        employeeRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs",HttpStatus.OK);
    }
}
