package com.tester.app.service;

import com.tester.app.dto.ApiResponseDto;
import com.tester.app.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;


public interface ITestCaseService {

    TestCaseDto save(TestCaseDto testCaseDto);

    List<TestCaseDto> findAll(LocalDate localDate);

    TestCaseDto findById(Long id) throws Exception;

    TestCaseDto update(Long id,TestCaseDto testCaseDto) throws Exception;

    ApiResponseDto delete(Long id) throws Exception;





}
