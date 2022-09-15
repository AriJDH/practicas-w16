package com.example.qatesters.util;

import com.example.qatesters.dto.ResTestCaseDTO;
import com.example.qatesters.model.TestCase;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    static public ResTestCaseDTO mapResTestCaseDTO(TestCase testCase) {
        return ResTestCaseDTO
                .builder()
                .id(testCase.getId())
                .description(testCase.getDescription())
                .tested(testCase.getTested())
                .passed(testCase.getPassed())
                .numberOfTries(testCase.getNumberOfTries())
                .build();
    }
    static public List<ResTestCaseDTO> mapListResTestCaseDTO(List<TestCase> testCases) {
        return testCases
                .stream()
                .map(testCase -> Mapper.mapResTestCaseDTO(testCase))
                .collect(Collectors.toList());
    }
}
