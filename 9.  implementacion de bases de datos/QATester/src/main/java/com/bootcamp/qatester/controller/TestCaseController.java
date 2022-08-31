package com.bootcamp.qatester.controller;

import com.bootcamp.qatester.model.TestCase;
import com.bootcamp.qatester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("testcases/new")
    public TestCase saveTestCase(@RequestBody TestCase testCase) {
        return testCaseService.save(testCase);
    }

    @GetMapping("testcases/{id}")
    public TestCase getTestCase(@PathVariable Long id) {
        return testCaseService.findById(id);
    }

    @PutMapping("testcases/{id}")
    public TestCase editTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        return testCaseService.edit(id, testCase);
    }

    @DeleteMapping("testcases/{id}")
    public String deleteTestCase(@PathVariable Long id) {
        return testCaseService.delete(id);
    }

    @GetMapping("testcases")
    public List<TestCase> getTestCasesByDate(@RequestParam(value = "last_update", required = false)
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                             LocalDate last_update) {
        return testCaseService.findAllOrByDate(last_update);
    }

}
