package com.tester.app.controller;

import com.tester.app.dto.DeleteTestCaseDto;
import com.tester.app.dto.TestCaseDto;
import com.tester.app.service.ITestCaseService;
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
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    private ResponseEntity<TestCaseDto> save(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.save(testCaseDto), HttpStatus.OK);

    }

    @GetMapping("")
    private ResponseEntity<List<TestCaseDto>> getAllTestCases(@RequestParam(value = "last_update",required = false) String localDate){

        return new ResponseEntity<>(testCaseService.findAll(localDate), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    private ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);

    }
    @PutMapping("/{id}")
    private ResponseEntity<TestCaseDto> updateTestCases(@PathVariable Long id,@RequestBody TestCaseDto testCaseDto) throws Exception {
        return new ResponseEntity<>(testCaseService.update(id,testCaseDto), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    private ResponseEntity<DeleteTestCaseDto> deleteTestCases(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);

    }

//    @GetMapping("")
//    private ResponseEntity<List<TestCaseDto>> getByDate(@RequestParam(value = "last_update",required = false) LocalDate localDate) throws Exception {
//        return new ResponseEntity<>(testCaseService.findByDate(localDate), HttpStatus.OK);
//
//    }
}
