package com.example.qatesters.controller;

import com.example.qatesters.model.TestCase;
import com.example.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class Controller{

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<String> saveTestCase(@RequestBody TestCase body) {

        testCaseService.saveTestCase(body);

        return new ResponseEntity<>("TestCase was created successfully", HttpStatus.valueOf(200));
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> getTestCases(){

        var res = testCaseService.getTestCases();

        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @GetMapping("/api/testcases/{id_case}")
    public ResponseEntity<TestCase> getTestCase(@PathVariable Long id_case){

        var res = testCaseService.findTestCase(id_case);

        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @PutMapping ("/api/testcases/{id_case}")
    public ResponseEntity<TestCase> updateTestCase(@RequestBody TestCase body, @PathVariable Long id_case){

        var res = testCaseService.updateTestCase(id_case, body);

        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @DeleteMapping ("/api/testcases/{id_case}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id_case){

        testCaseService.deleteTestCase(id_case);

        return new ResponseEntity<>("TestCase was delete successfully", HttpStatus.valueOf(200));
    }

    @GetMapping("/api/testcases/dates")
    public ResponseEntity<List<TestCase>> getLastUpdatesTestCases(@RequestParam String last_update){

        var res = testCaseService.lastUpdates(last_update);

        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }
}
