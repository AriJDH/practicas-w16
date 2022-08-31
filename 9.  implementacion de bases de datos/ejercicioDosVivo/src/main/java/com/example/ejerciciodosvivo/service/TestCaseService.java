package com.example.ejerciciodosvivo.service;

import com.example.ejerciciodosvivo.dto.ResponseTestDto;
import com.example.ejerciciodosvivo.dto.TestCaseDto;
import com.example.ejerciciodosvivo.entity.TestCase;
import com.example.ejerciciodosvivo.exception.UserNotExistException;
import com.example.ejerciciodosvivo.repository.TestCaseRepository;
import com.example.ejerciciodosvivo.util.Mapper;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService{
    @Autowired
    TestCaseRepository repository;


    @Override
    public ResponseTestDto createTest(TestCaseDto test) {
        TestCase testCase= repository.save(Mapper.testCaseToTestCaseDto(test));
        return Mapper.testCaseDtoToTestCase(testCase);
    }

    @Override
    public List<ResponseTestDto> findAll(String date) {
        if(date!=null){
            List<TestCase> testCases=repository.findAllByLastUpdateAfter(LocalDate.parse(date));
            return Mapper.listTestCaseToListTestCaseDto(testCases);
        }
        return Mapper.listTestCaseToListTestCaseDto(repository.findAll());
    }

    @Override
    public ResponseTestDto findById(Long id) {
        TestCase testCase=repository.findById(id).orElseThrow(()-> new UserNotExistException(id));

        return Mapper.testCaseDtoToTestCase(testCase);
    }

    @Override
    public ResponseTestDto updateTestById(TestCaseDto test, Long id) {
        TestCase testCase=repository.findById(id).orElseThrow(()-> new UserNotExistException(id));
        testCase.setTested(test.getTested());
        testCase.setPassed(test.getPassed());
        testCase.setDescription(test.getDescription());
        testCase.setLastUpdate(test.getLastUpdate());
        testCase.setNumberOfTries(test.getNumberOfTries());

        repository.save(testCase);
        return Mapper.testCaseDtoToTestCase(testCase);
    }

    @Override
    public void delateById(Long id) {
        if(!repository.existsById(id))  throw new UserNotExistException(id) ;
        repository.deleteById(id);
    }

}
