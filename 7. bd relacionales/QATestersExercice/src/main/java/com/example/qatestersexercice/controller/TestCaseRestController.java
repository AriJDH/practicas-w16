package com.example.qatestersexercice.controller;


import com.example.qatestersexercice.dto.InsertTestCaseDto;
import com.example.qatestersexercice.dto.TestCaseDto;
import com.example.qatestersexercice.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestCaseRestController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public void createTestcase(@RequestBody InsertTestCaseDto testCase){
        testCaseService.createTestCase(testCase);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDto>> getAllTestCases(){
        ResponseEntity<List<TestCaseDto>> respuesta = new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
        return respuesta;
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id),HttpStatus.OK);
    }


    @PostMapping("/api/testcases/{id}")
    public void updateTestCase(@PathVariable long id, @RequestBody TestCaseDto edit){
        testCaseService.updateTestCase(id,edit);
    }

    @DeleteMapping("/api/testcases/{id}")
    public void deleteTestCaseById(@PathVariable long id){
        testCaseService.deleteTestCaseById(id);
    }

    @GetMapping("/api/testcases/Hola")
    public ResponseEntity<List<TestCaseDto>> getTestCaseUpdatedAfterADate (@RequestParam String last_update){
        return new ResponseEntity<>(testCaseService.getTestCaseUpdatedAfterADate(last_update),HttpStatus.OK);
    }
}
