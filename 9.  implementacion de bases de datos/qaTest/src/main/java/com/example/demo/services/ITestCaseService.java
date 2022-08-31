package com.example.demo.services;

import com.example.demo.dto.GetTestCasesDTO;

import java.util.List;

public interface ITestCaseService {
    public List<GetTestCasesDTO> getTestCases();
}
