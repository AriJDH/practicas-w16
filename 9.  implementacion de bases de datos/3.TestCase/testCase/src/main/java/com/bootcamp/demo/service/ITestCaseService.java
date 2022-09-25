package com.bootcamp.demo.service;

import com.bootcamp.demo.DTO.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    String saveTest(TestCaseDTO testCaseDTO);

    List<TestCaseDTO> getAll();

    TestCaseDTO getById(Long id);

    String updateTest(Long id, TestCaseDTO testCaseDTO);

    String deleteTest(Long id);

    List<TestCaseDTO> getByLastUpdate(LocalDate lastUpdate);

}
