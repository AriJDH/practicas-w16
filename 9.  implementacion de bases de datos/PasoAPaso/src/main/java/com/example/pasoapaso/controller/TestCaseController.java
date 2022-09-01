package com.example.pasoapaso.controller;

import com.example.pasoapaso.model.TestCase;
import com.example.pasoapaso.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<String> createJewerly(@RequestBody TestCase testCase){
        testCaseService.saveTestCase(testCase);
        return new ResponseEntity<>("La joya fue agregado correctamente.", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<TestCase> getTestCases(
            @RequestParam Optional<String> lastUpdate
    ){
        return testCaseService.getTestCase(lastUpdate.orElse(""));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable long id){
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("La joya fue eliminada correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public TestCase editTestCase(@PathVariable long id,
                           @RequestParam("description") String description,
                           @RequestParam("tested") boolean tested,
                           @RequestParam("passed") boolean passed,
                           @RequestParam("numberOfTries") int numberOfTries) {
        TestCase testCase = testCaseService.findTestCase(id);


        testCase.setDescription(description);
        testCase.setTested(tested);
        testCase.setPassed(passed);
        testCase.setNumberOfTries(numberOfTries);
        testCase.setLastUpdate(LocalDate.now());

        testCaseService.saveTestCase(testCase);
        return testCase;
    }

    @GetMapping("/{id}")
    public TestCase getTestCase(@PathVariable long id){
        return testCaseService.findTestCase(id);
    }
}
