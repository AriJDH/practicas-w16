package com.example.pasoapaso.service;
import com.example.pasoapaso.model.TestCase;

import java.util.List;

public interface ITestCaseService {

    public List<TestCase> getTestCase(String lastUpdate);
    public void saveTestCase(TestCase testCase);
    public void deleteTestCase(long id);
    public TestCase findTestCase(long id);
}