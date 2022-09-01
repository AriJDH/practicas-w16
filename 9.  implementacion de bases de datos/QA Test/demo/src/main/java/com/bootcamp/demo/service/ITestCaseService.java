package com.bootcamp.demo.service;

import com.bootcamp.demo.DTO.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {
    String saveTest(TestCaseDTO testCaseDTO);

    List<TestCaseDTO> getAll();

    String updateTest(Long id, TestCaseDTO testCaseDTO);

    String deleteTest(Long id);

}
