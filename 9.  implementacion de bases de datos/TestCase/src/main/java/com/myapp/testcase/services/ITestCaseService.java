package com.myapp.testcase.services;

import com.myapp.testcase.dto.TestCaseDTO;
import org.aspectj.weaver.ast.Test;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void saveTestCase(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCase();
    List<TestCaseDTO> getAllTestCaseByDate(LocalDate date);
    void deleteTestCase(Long id);
    TestCaseDTO getTestCaseById(Long id);

    void updateTestCase(Long id, TestCaseDTO testCaseDTO);


}
