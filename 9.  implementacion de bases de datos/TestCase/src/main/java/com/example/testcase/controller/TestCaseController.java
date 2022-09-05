package com.example.testcase.controller;

import com.example.testcase.model.TestCase;
import com.example.testcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService iTestCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<String> newTestCase (@RequestBody TestCase testCase)
    {
        this.iTestCaseService.saveTestCases(testCase);
        return  ResponseEntity.ok("El test fue creado correctamente");
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> getAll()
    {
        return ResponseEntity.ok(this.iTestCaseService.getTestCases());
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> finById(@PathVariable Long id)
    {
        return ResponseEntity.ok(this.iTestCaseService.findTestCases(id));
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<String> updateTest(@PathVariable Long id, @RequestBody TestCase testCase)
    {
        this.iTestCaseService.updateTest(testCase,id);
        return  ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable Long id)
    {
        this.iTestCaseService.deleteTestCases(id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/api/testcasesDate")
    public ResponseEntity<List<TestCase>> getByDate(@RequestParam("last_date") String last_date)
    {
        return ResponseEntity.ok(this.iTestCaseService.findTestCasesByDate(last_date));
    }




}
