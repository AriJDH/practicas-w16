package com.example.qatesters.controller;

import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.service.ITestCaseService;
import com.example.qatesters.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> findAll(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update){
        return new ResponseEntity<>(testCaseService.findAll(last_update), HttpStatus.FOUND);
    }

    @PostMapping("/new")
    public ResponseEntity<?> add(@RequestBody TestCaseDTO testCaseDTO){
        testCaseService.add(testCaseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> update(@RequestBody TestCaseDTO testCaseDTO, @PathVariable Long id){
        return new ResponseEntity<>(testCaseService.update(testCaseDTO, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        testCaseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
