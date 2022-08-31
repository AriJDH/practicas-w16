package com.meli.consigna.controller;

import com.meli.consigna.entity.TestCase;
import com.meli.consigna.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public TestCase saveTestCase(@RequestBody TestCase testCase) {
        return testCaseService.saveTestCase(testCase);
    }

    @GetMapping("")
    public List<TestCase> getTestCases(@RequestParam(name="last_update", required = false) String lastUpdate) {
        if (lastUpdate == null) {
            return testCaseService.getTestCases();
        } else {
            return testCaseService.getTestCasesByDate(lastUpdate);
        }
    }

    @GetMapping("/{id}")
    public TestCase findTestCase(@PathVariable Long id) {
        return testCaseService.findTestCase(id);
    }

    @PutMapping("/{id}")
    public TestCase editTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        TestCase testCaseNew = testCaseService.findTestCase(id);

        testCaseNew.setDescription(testCase.getDescription());
        testCaseNew.setTested(testCase.getTested());
        testCaseNew.setPassed(testCase.getPassed());
        testCaseNew.setNumberOfTries(testCase.getNumberOfTries());
        testCaseNew.setLastUpdate(testCase.getLastUpdate());

        return testCaseService.saveTestCase(testCaseNew);
    }

    @PostMapping("/{id}")
    public String deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return "Eliminado con exito";
    }

}
