package com.example.testers.controller;

import com.example.testers.model.TestCase;
import com.example.testers.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {

    @Autowired
    ITestCaseService testServ;

    @PostMapping("testcases/new")
    public ResponseEntity<String> newTestCase(@RequestBody TestCase testCase) {
        this.testServ.saveTestCase(testCase);
        return ResponseEntity.ok("El test fue creado correctamente");
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCase>> getAllTestCases() {
        return ResponseEntity.ok(this.testServ.getTestCases());
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCase> findTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(this.testServ.findTestCase(id));
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        this.testServ.updateTestCase(testCase, id);
        return  ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        this.testServ.deleteTestCase(id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/testcases1")
    public ResponseEntity<List<TestCase>> getTestCasesByDate(@RequestParam("last_update") String last_date) {
        return ResponseEntity.ok(this.testServ.findTestCasesByDate(last_date));
    }
}
