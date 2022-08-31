package com.meli.consigna.service;

import com.meli.consigna.entity.TestCase;

import java.util.List;

public interface ITestCaseService {
    List<TestCase> getTestCases();
    TestCase saveTestCase(TestCase testCase);
    void deleteTestCase(Long id);
    TestCase findTestCase(Long id);
    List<TestCase> getTestCasesByDate(String date);
}
