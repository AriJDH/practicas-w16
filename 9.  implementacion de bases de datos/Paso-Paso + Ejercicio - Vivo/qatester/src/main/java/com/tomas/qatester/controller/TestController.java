package com.tomas.qatester.controller;

import com.tomas.qatester.dto.TestCaseDTO;
import com.tomas.qatester.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    ITestService service;

    @PostMapping ("/testcases/new")
    public ResponseEntity createTest(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity(service.createTest(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping("/testcases")
    public ResponseEntity findAllTest(@RequestParam(required = false) String last_update ){
        return new ResponseEntity(service.findAllTestCase(last_update), HttpStatus.OK);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity findTestId(@PathVariable Long id){
        return new ResponseEntity(service.findId(id), HttpStatus.OK);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity updateTest(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity(service.updateTest(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity deleteTest(@PathVariable Long id) {
        return new ResponseEntity(service.deleteTest(id), HttpStatus.OK);
    }

}
