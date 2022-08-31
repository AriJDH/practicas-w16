package com.bootcamp.testcase.service;

import com.bootcamp.testcase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestServices {
    List<TestCase> getTest(String localDate);
    TestCase getFindById(Long Id);
    void deleteById(Long Id);
    void create(TestCase testCase);
    TestCase updateById(Long Id, TestCase testCase);


}
