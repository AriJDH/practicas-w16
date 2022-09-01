package com.miniseries.controllers;

import com.miniseries.dto.TestCaseDTO;
import com.miniseries.services.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.create(testCaseDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> find() {
        return new ResponseEntity<>(testCaseService.find(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.update(id, testCaseDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        testCaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
