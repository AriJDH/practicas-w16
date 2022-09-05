package com.example.testcase.service;

import com.example.testcase.model.TestCase;


import java.time.LocalDate;

import java.util.List;


public interface ITestCaseService {
    public List<TestCase> getTestCases ();
    public void saveTestCases (TestCase testCase);
    public void deleteTestCases (Long id);
    public TestCase findTestCases (Long id);
    public void updateTest(TestCase testCase,Long id);
    public  List<TestCase> findTestCasesByDate(String date);


}
