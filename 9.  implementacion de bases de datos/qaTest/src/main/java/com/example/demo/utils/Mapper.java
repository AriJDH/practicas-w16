package com.example.demo.utils;

import com.example.demo.dto.GetTestCasesDTO;
import com.example.demo.entity.TestCase;

public class Mapper {
    public static GetTestCasesDTO toDTO(TestCase testCase){
        return new GetTestCasesDTO(testCase.getId(), testCase.getDescription());
    }
}
