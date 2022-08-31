package com.tester.app.service;

import com.tester.app.dto.DeleteTestCaseDto;
import com.tester.app.dto.TestCaseDto;
import com.tester.app.model.TestCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface ITestCaseService {

    TestCaseDto save(TestCaseDto testCaseDto);

    List<TestCaseDto> findAll(String localDate);

    TestCaseDto findById(Long id) throws Exception;

    TestCaseDto update(Long id,TestCaseDto testCaseDto) throws Exception;

    DeleteTestCaseDto delete(Long id) throws Exception;





}
