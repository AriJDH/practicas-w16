package com.example.spring.qatesters.service;
import com.example.spring.qatesters.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    List<TestCase> getTestCase(String lastUpdate);
    void saveTestCase(TestCase testCase);
    void deleteTestCase(long id);
    TestCase findTestCase(long id);
}