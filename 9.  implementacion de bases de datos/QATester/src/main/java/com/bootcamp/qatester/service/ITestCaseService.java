package com.bootcamp.qatester.service;

import com.bootcamp.qatester.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCase save(TestCase testCase);

    TestCase findById(Long id);

    String delete(Long id);

    TestCase edit(Long id, TestCase testCase);

    List<TestCase> findAllOrByDate(LocalDate last_update);
}
