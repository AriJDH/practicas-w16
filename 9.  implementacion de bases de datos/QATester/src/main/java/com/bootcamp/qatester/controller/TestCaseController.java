package com.bootcamp.qatester.controller;

import com.bootcamp.qatester.dto.TestCaseDto;
import com.bootcamp.qatester.dto.TestCaseDtoResponse;
import com.bootcamp.qatester.service.ITestCaseService;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDtoResponse> createTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(iTestCaseService.createTestCase(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseDtoResponse>> getAllTestCases(){
        return new ResponseEntity<>(iTestCaseService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDtoResponse> getTestCaseById(@PathVariable Long id){
        return  new ResponseEntity<>(iTestCaseService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<TestCaseDtoResponse> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(iTestCaseService.updateTestCase(id, testCaseDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(iTestCaseService.deleteTestCase(id),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDtoResponse>> getTestCaseByDate (@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate last_update){
        return  new ResponseEntity<>(iTestCaseService.getByDate(last_update),HttpStatus.OK);
    }

}
