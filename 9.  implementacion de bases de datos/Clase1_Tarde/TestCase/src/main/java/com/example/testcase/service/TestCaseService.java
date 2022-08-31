package com.example.testcase.service;

import com.example.testcase.dto.TestCaseDTO;
import com.example.testcase.dto.TestCaseIdDTO;
import com.example.testcase.exception.IdError;
import com.example.testcase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    String addTest(TestCaseDTO testCaseDTO);
    TestCaseIdDTO getTestById(long id) throws IdError;
    List<TestCaseIdDTO> getAllTest();
    String delete(long id) throws IdError;
    String update(long id, TestCaseDTO testCaseDTO) throws IdError;
    List<TestCaseIdDTO> getByDate(LocalDate date);

}
