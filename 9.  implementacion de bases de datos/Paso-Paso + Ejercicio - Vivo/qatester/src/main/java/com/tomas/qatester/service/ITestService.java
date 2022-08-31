package com.tomas.qatester.service;

import com.tomas.qatester.dto.ListTestCaseDTO;
import com.tomas.qatester.dto.ResponseDTO;
import com.tomas.qatester.dto.TestCaseDTO;

public interface ITestService {

    ResponseDTO createTest(TestCaseDTO testCaseDTO);
    ListTestCaseDTO findAllTestCase(String date);
    TestCaseDTO findId(Long id);
    ResponseDTO updateTest(Long id, TestCaseDTO testCaseDTO);
    ResponseDTO deleteTest(Long id);
}
