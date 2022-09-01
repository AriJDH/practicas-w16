package com.example.ejerciciodosvivo.util;

import com.example.ejerciciodosvivo.dto.ResponseTestDto;
import com.example.ejerciciodosvivo.dto.TestCaseDto;
import com.example.ejerciciodosvivo.entity.TestCase;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static TestCase testCaseToTestCaseDto(TestCaseDto testCaseDto) {

        return TestCase.builder()
                .tested(testCaseDto.getTested())
                .description(testCaseDto.getDescription())
                .passed(testCaseDto.getPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(testCaseDto.getLastUpdate())
                .build();

    }

    public static ResponseTestDto testCaseDtoToTestCase(TestCase testCase) {

        return ResponseTestDto.builder()
                .id(testCase.getId())
                .tested(testCase.getTested())
                .description(testCase.getDescription())
                .passed(testCase.getPassed())
                .numberOfTries(testCase.getNumberOfTries())
                .lastUpdate(testCase.getLastUpdate())
                .build();

    }

    public static List<ResponseTestDto> listTestCaseToListTestCaseDto(List<TestCase> testCase) {

        return testCase
                .stream()
                .map(Mapper::testCaseDtoToTestCase)
                .collect(Collectors.toList())
                ;

    }
}
