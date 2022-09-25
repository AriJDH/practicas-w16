package com.bootcamp.demo.controller;

import com.bootcamp.demo.DTO.TestCaseDTO;
import com.bootcamp.demo.service.ITestCaseService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity<String> saveTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(iTestCaseService.saveTest(testCaseDTO), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TestCaseDTO>> getAllTest(){
        return new ResponseEntity<>(iTestCaseService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(iTestCaseService.updateTest(id, testCaseDTO), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.deleteTest(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<TestCaseDTO>> getByLastUpdate(@RequestParam(value="last_update")   @JsonFormat(pattern="yyyy-MM-dd") LocalDate lastUpdate){
        return new ResponseEntity<>(iTestCaseService.getByLastUpdate(lastUpdate), HttpStatus.OK);
    }
}

