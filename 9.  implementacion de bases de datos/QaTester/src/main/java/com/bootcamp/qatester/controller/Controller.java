package com.bootcamp.qatester.controller;


import com.bootcamp.qatester.entity.TestCase;
import com.bootcamp.qatester.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class Controller {


    @Autowired
    private IService service;

    @GetMapping("/api/testcases")
    public List<TestCase> getAlltests () {

       return service.getAllTests();

    }

    //falta dto y expeciones es para probar
    @GetMapping("/api/testcases/{id}")
    public TestCase getTestById(@PathVariable long id) {
        return service.findTest(id);
    }

    @PostMapping("/api/testcases/new")
    public String createTest(@RequestBody TestCase testCase) {
        service.saveTest(testCase);
        return "OK";
    }

    @DeleteMapping("/api/testcases/{id}")
    public String deleteTest(@PathVariable long id) {
        service.deleteTest(id);
        return "OK";
    }

    @PutMapping ("/api/testcases/id")
    public String editTest (@PathVariable long id, @RequestBody TestCase edit){
        service.deleteTest(id);
        service.saveTest(edit);
        return "OK";
    }

    @GetMapping ("/api/testcases/")
    public List<TestCase> getTestsAfterDate(@RequestParam LocalDate lastUpdate){
        return service.getAllTestsAfterDate(lastUpdate);
    }

}
