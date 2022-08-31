package com.example.demo.controllers;

import com.example.demo.dto.GetTestCasesDTO;
import com.example.demo.services.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestCaseController {

    @Autowired
    private ITestCaseService iTestCaseService;

    @GetMapping("/testCases")
    public ResponseEntity<List<GetTestCasesDTO>> getTestCases() {
        return new ResponseEntity<>( iTestCaseService.getTestCases(), HttpStatus.OK);
    }

}
