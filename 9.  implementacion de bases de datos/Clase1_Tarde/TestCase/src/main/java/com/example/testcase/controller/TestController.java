package com.example.testcase.controller;

import com.example.testcase.dto.TestCaseDTO;
import com.example.testcase.dto.TestCaseIdDTO;
import com.example.testcase.exception.IdError;
import com.example.testcase.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestController {
    final TestCaseService testCaseService;

    public TestController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createNewJoya(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.addTest(testCaseDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseIdDTO>> getAll(){
        return new ResponseEntity<>(testCaseService.getAllTest(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseIdDTO> getById(@PathVariable long id) throws IdError {
        return new ResponseEntity<>(testCaseService.getTestById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody TestCaseDTO testCaseDTO) throws IdError {
        return new ResponseEntity<>(testCaseService.update(id,testCaseDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) throws IdError {
        return new ResponseEntity<>(testCaseService.delete(id),HttpStatus.OK);
    }

    @GetMapping("/last_update")
    public ResponseEntity<List<TestCaseIdDTO>> getByDate(@RequestParam LocalDate last_update){
    return new ResponseEntity<>(testCaseService.getByDate(last_update),HttpStatus.OK);

    }






}
