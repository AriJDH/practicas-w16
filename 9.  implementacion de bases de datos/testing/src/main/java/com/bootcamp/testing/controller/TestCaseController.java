package com.bootcamp.testing.controller;

import com.bootcamp.testing.dto.TestCaseDto;
import com.bootcamp.testing.service.TestCaseService;
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
    private TestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createPost(@RequestBody TestCaseDto testCase) {
        testCaseService.saveTestCase(testCase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getByDateUpdated(@PathVariable Long id){
        var testCase = testCaseService.getById(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCase(@PathVariable Long id,@RequestBody TestCaseDto testCase){
        testCase.setIdCase(id);
        testCaseService.updateTestCase(testCase,id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getByDateUpdated(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update) {
        List<TestCaseDto> filtered;
        if(last_update == null)
             filtered = testCaseService.getAllCases();
        else
            filtered = testCaseService.filterByDate(last_update);

        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }
}
