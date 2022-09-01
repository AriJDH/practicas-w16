package com.example.qatesters.service;

import com.example.qatesters.model.TestCase;
import org.aspectj.weaver.ast.Test;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCase findTestCase(Long id);
    TestCase updateTestCase(Long id, TestCase testCase);
    void saveTestCase(TestCase jewerly);
    void deleteTestCase(Long id);
    List<TestCase> getTestCases();
    List<TestCase> lastUpdates(String last);
}
