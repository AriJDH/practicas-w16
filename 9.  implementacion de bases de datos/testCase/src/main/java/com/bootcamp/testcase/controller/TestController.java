package com.bootcamp.testcase.controller;

import com.bootcamp.testcase.model.TestCase;
import com.bootcamp.testcase.service.ITestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    ITestServices services;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<Object> create(@RequestBody TestCase dto)
    {
        return  new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> getAll(@PathVariable(required = false) String last_update)
    {
        return new ResponseEntity<>(services.getTest(last_update), HttpStatus.OK);
    }

    @PostMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> get(@PathVariable Long id)
    {
        return new ResponseEntity<>(services.getFindById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<Object> update(@RequestParam Long id, @RequestBody TestCase dto){
        return  new ResponseEntity<>(services.updateById(id, dto), HttpStatus.OK);
    }
    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<Object> update(@RequestParam Long id){
        services.deleteById(id);
        return  new ResponseEntity<>(null, HttpStatus.OK);
    }



}
