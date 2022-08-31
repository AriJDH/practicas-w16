package com.myapp.testcase.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myapp.testcase.dto.TestCaseDTO;
import com.myapp.testcase.services.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<Void> saveTestCase(@RequestBody TestCaseDTO testCaseDTO){
        testCaseService.saveTestCase(testCaseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAllTestCaseByDate(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update){
        return new ResponseEntity<>(testCaseService.getAllTestCaseByDate(last_update),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        testCaseService.updateTestCase(id, testCaseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
