package com.example.testers.service;

import com.example.testers.model.TestCase;

import java.util.List;

public interface ITestCaseService {

    void saveTestCase(TestCase testCase);
    List<TestCase> getTestCases();
    TestCase findTestCase(Long id);
    void updateTestCase(TestCase testCase, Long id);
    void deleteTestCase(Long id);
    List<TestCase> findTestCasesByDate(String date);
}
