package com.bootcamp.qatester.service;

import com.bootcamp.qatester.dto.TestCaseDto;
import com.bootcamp.qatester.dto.TestCaseDtoResponse;
import com.bootcamp.qatester.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCaseDtoResponse createTestCase(TestCaseDto test);

    TestCaseDtoResponse getById(Long id);

    List<TestCaseDtoResponse> getAll ();

    Boolean deleteTestCase(Long id);

    TestCaseDtoResponse updateTestCase(Long id, TestCaseDto testCaseDto);

    List<TestCaseDtoResponse> getByDate(LocalDate date);




}
