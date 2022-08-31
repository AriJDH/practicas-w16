package com.example.qatestersexercice.service;

import com.example.qatestersexercice.dto.InsertTestCaseDto;
import com.example.qatestersexercice.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public void createTestCase(InsertTestCaseDto testcase);

    List<TestCaseDto> getAllTestCases();

    TestCaseDto getTestCaseById(long id);

    public void updateTestCase(long id, TestCaseDto editedTestCase);

    public void deleteTestCaseById(long id );

    public List<TestCaseDto> getTestCaseUpdatedAfterADate(String date);
}
