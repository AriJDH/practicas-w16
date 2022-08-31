package com.bootcamp.qatester.service;

import com.bootcamp.qatester.dto.TestCaseDto;
import com.bootcamp.qatester.dto.TestCaseDtoResponse;
import com.bootcamp.qatester.model.TestCase;
import com.bootcamp.qatester.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    private ITestCaseRepository iTestCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseDtoResponse createTestCase(TestCaseDto test) {
        TestCase testCase = iTestCaseRepository.save(modelMapper.map(test,TestCase.class));
        return modelMapper.map(testCase, TestCaseDtoResponse.class);
    }

    @Override
    public TestCaseDtoResponse getById(Long id) {
        TestCase testCase = iTestCaseRepository.findById(id).orElse(null);
        if(testCase==null){
            return  null;
        }
        return modelMapper.map(testCase, TestCaseDtoResponse.class);
    }

    @Override
    public List<TestCaseDtoResponse> getAll() {
        List<TestCase> testCases = iTestCaseRepository.findAll();
        return testCases.stream().map(x->modelMapper.map(x, TestCaseDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteTestCase(Long id) {
        try{
            iTestCaseRepository.deleteById(id);
            return true;
        } catch (Exception e){
         return  false;
        }
    }

    @Override
    public TestCaseDtoResponse updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = iTestCaseRepository.findById(id).orElse(null);
        if(testCase!=null){
            testCase.setDescription(testCaseDto.getDescription());
            testCase.setLastUpdate(testCaseDto.getLastUpdate());
            testCase.setTested(testCaseDto.getTested());
            testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
            testCase.setPassed(testCaseDto.getPassed());
        }
        iTestCaseRepository.save(testCase);
        return modelMapper.map(testCase,TestCaseDtoResponse.class);
    }

    @Override
    public List<TestCaseDtoResponse> getByDate(LocalDate date) {
        List<TestCase> testCases = iTestCaseRepository.findAll().stream().filter(x->x.getLastUpdate().isAfter(date))
                .collect(Collectors.toList());
        return testCases.stream().map(x->modelMapper.map(x, TestCaseDtoResponse.class)).collect(Collectors.toList());
    }
}
