package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    List<TestCaseDTO> findAll(LocalDate last_update);
    void add(TestCaseDTO testCaseDTO);
    TestCaseDTO findById(Long id);
    TestCaseDTO update(TestCaseDTO testCaseDTO, Long id);
    void deleteById(Long id);
}
