package com.miniseries.services;

import com.miniseries.dto.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {

    TestCaseDTO create(TestCaseDTO testCaseDTO);
    TestCaseDTO findById(Long id);
    List<TestCaseDTO> find();
    TestCaseDTO update(Long id, TestCaseDTO testCaseDTO);
    void delete(Long id);
    List<TestCaseDTO> findByFecha(String fecha);

}
